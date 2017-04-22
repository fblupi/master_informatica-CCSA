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

// 2. ¿Cómo podríamos obtener las ciudades más distintas en cada país?

// 3. ¿Qué ocurre si en un país hay dos parejas de ciudades que están a la 
//    misma distancia mínima? ¿Cómo harías para que aparecieran todas?

// 4. ¿Cómo podríamos obtener adicionalmente la cantidad de parejas de 
//    ciudades evaluadas para cada país consultado?

// 5. ¿Cómo podríamos la distancia media entre las ciudades de cada país?

// 6. ¿Mejoraría el rendimiento si creamos un índice? ¿Sobre qué campo? Comprobadlo
