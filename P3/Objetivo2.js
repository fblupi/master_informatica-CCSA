// A partir de la colección pedidos utilizaremos consultas más complejas por medio de los operadores de agregación (pipeline). Por facilidad se indica la consulta en formato SQL estándar. Las tareas a realizar en este caso obtener:

// 1. Nº total de clientes
db.pedidos.count()

// 2. Nº total de clientes de Jaén
db.pedidos.find({"Localidad": "Jaen"}).count()

// 3. Facturación total de clientes por localidad

// 4. Facturación media de clientes por localidad para las localidades distintas a "Jaen" con facturación media mayor de 5000. Ordenación por Localidad descendente. Eliminar el _id y poner el nombre en mayúsculas.

// 5. Calcula la cantidad total facturada por cada cliente (uso de "unwind")
