// A partir de la colección pedidos utilizaremos consultas más complejas por 
// medio de los operadores de agregación (pipeline). Por facilidad se indica la
// consulta en formato SQL estándar. Las tareas a realizar en este caso obtener:

// 1. Nº total de clientes

db.pedidos.count();

// 2. Nº total de clientes de Jaén

db.pedidos.find(
    {"Localidad": "Jaen"}
).count();

// 3. Facturación total de clientes por localidad

db.pedidos.aggregate(
    [
        {
            $group: 
            {
                "_id": "$Localidad", 
                facturacion_total: {$sum: "$Facturacion"}
            }
        }
    ]
);

// 4. Facturación media de clientes por localidad para las localidades 
// distintas a "Jaen" con facturación media mayor de 5000. Ordenación por 
// Localidad descendente. Eliminar el _id y poner el nombre en mayúsculas.

// !!! Queda lo de eliminar el _id y poner el nombre en mayúsculas

db.pedidos.aggregate(
    [
        {
            $group: 
            {
                "_id": "$Localidad", 
                facturacion_media: {$avg: "$Facturacion"}
            }
        }, 
        {
            $match: 
            {
                "_id": {$ne: "Jaen"}, 
                facturacion_media: {$gt: 5000}
            }
        }, 
        {
            $sort: 
            {
                "_id": -1
            }
        }
    ]
);

// 5. Calcula la cantidad total facturada por cada cliente (uso de "unwind")

