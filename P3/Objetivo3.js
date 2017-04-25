// Vamos a utilizar la base de datos libre GeoWorldMap de GeoBytes. Es una base
// de datos de países, con sus estados/regiones y ciudades importantes. Sobre
// esta Base de datos vamos a obtener el par de ciudades que se encuentran más
// cercanas en cada país, excluyendo EEUU.
//
// Vamos a importar en nuestra BD de MongoDB un archivo con 37245 ciudades del
// mundo que está en format csv (/home/Cities.csv)
//
// mongoimport -u <user> -p <clave> --db <bd> --collection cities --type csv
//             --headerline --file /home/Cities.csv

// 1. Encontrar las ciudades más cercanas sobre la colección recién creada 
//    mediante un enfoque MapReduce conforme a los pasos que se ilustran en el 
//    tutorial práctico

db.runCommand({
    mapReduce: "cities",
    map: function Map() {
        emit(
            this.CountryID,
            {
                "data":
                [
                    {
                        "city": this.City,
                        "lat": this.Latitude,
                        "lon": this.Longitude
                    }
                ]
            }
        );
    },
    reduce: function Reduce(key, values) {
        var reduced = { "data": [] };
        for (var i in values) {
            var inter = values[i];
            for (var j in inter.data) {
                reduced.data.push(inter.data[j]);
            }
        }
        return reduced;
    },
    finalize: function Finalize(key, reduced) {
        if (reduced.data.length == 1) {
            return {
                "message": "Este país solo contiene una ciudad"
            };
            var min_dist = 999999999999;
            var city1 = { "name": "" };
            var city2 = { "name": "" };
            var c1;
            var c2;
            var d2;
            for (var i in reduced.data) {
                for (var j in reduced.data) {
                    if (i >= j) {
                        continue;
                    }
                    c1 = reduced.data[i];
                    c2 = reduced.data[j];
                    d2 = (c1.lat - c2.lat) * (c1.lat - c2.lat) + (c1.lon - c2.lon) * (c1.lon - c2.lon);
                    if (d2 < min_dist && d2 > 0) {
                        min_dist = d2;
                        city1 = c1;
                        city2 = c2;
                    }
                }
            }
            return {
                "city1": city1.name,
                "city2": city2.name,
                "dist": Math.sqrt(min_dist)
            };
        }
    },
    out: {
        merge: "ciudades_proximas"
    }
});

// 2. ¿Cómo podríamos obtener las ciudades más distintas en cada país?

// 3. ¿Qué ocurre si en un país hay dos parejas de ciudades que están a la 
//    misma distancia mínima? ¿Cómo harías para que aparecieran todas?

// 4. ¿Cómo podríamos obtener adicionalmente la cantidad de parejas de 
//    ciudades evaluadas para cada país consultado?

// 5. ¿Cómo podríamos la distancia media entre las ciudades de cada país?

// 6. ¿Mejoraría el rendimiento si creamos un índice? ¿Sobre qué campo? Comprobadlo
