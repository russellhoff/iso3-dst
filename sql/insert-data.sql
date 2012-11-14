/*
-- Query: SELECT * FROM proyectoiso3.alumnos
LIMIT 0, 1000

-- Date: 2012-11-14 10:21
*/
INSERT INTO `alumnos` (`ALM_DNI`,`ALM_PASSWORD`,`ALM_NOMBRE`,`ALM_TELEFONO`) VALUES (1067499,'1234','Leslie Jurado Naranjo','945295836');
INSERT INTO `alumnos` (`ALM_DNI`,`ALM_PASSWORD`,`ALM_NOMBRE`,`ALM_TELEFONO`) VALUES (13940688,'1234','Pacífico Sánchez Escobedo','987098543');
INSERT INTO `alumnos` (`ALM_DNI`,`ALM_PASSWORD`,`ALM_NOMBRE`,`ALM_TELEFONO`) VALUES (20686524,'1234','Joscio Argüello Nevarez','987654687');
INSERT INTO `alumnos` (`ALM_DNI`,`ALM_PASSWORD`,`ALM_NOMBRE`,`ALM_TELEFONO`) VALUES (23361291,'1234','Ara Tórrez Oquendo','945295768');
INSERT INTO `alumnos` (`ALM_DNI`,`ALM_PASSWORD`,`ALM_NOMBRE`,`ALM_TELEFONO`) VALUES (31833384,'1234','Libia Barrientos Escobar','961529453');
INSERT INTO `alumnos` (`ALM_DNI`,`ALM_PASSWORD`,`ALM_NOMBRE`,`ALM_TELEFONO`) VALUES (32342151,'1234','Amilcar Madrigal Menchaca','987540914');
INSERT INTO `alumnos` (`ALM_DNI`,`ALM_PASSWORD`,`ALM_NOMBRE`,`ALM_TELEFONO`) VALUES (40097371,'1234','André Baca Rael','946552957');
INSERT INTO `alumnos` (`ALM_DNI`,`ALM_PASSWORD`,`ALM_NOMBRE`,`ALM_TELEFONO`) VALUES (60522675,'1234','Akemi Briones Parra','934957355');
INSERT INTO `alumnos` (`ALM_DNI`,`ALM_PASSWORD`,`ALM_NOMBRE`,`ALM_TELEFONO`) VALUES (66881939,'1234','Fedor Cadena Serrato','965295463');
INSERT INTO `alumnos` (`ALM_DNI`,`ALM_PASSWORD`,`ALM_NOMBRE`,`ALM_TELEFONO`) VALUES (78405443,'1234','Pavel Benavidez Moreno','945039476');
INSERT INTO `alumnos` (`ALM_DNI`,`ALM_PASSWORD`,`ALM_NOMBRE`,`ALM_TELEFONO`) VALUES (92878586,'1234','Esaú Regalado Caraballo','910543276');
INSERT INTO `alumnos` (`ALM_DNI`,`ALM_PASSWORD`,`ALM_NOMBRE`,`ALM_TELEFONO`) VALUES (93925891,'1234','Maclovio Salcedo Enríquez','987604326');
INSERT INTO `alumnos` (`ALM_DNI`,`ALM_PASSWORD`,`ALM_NOMBRE`,`ALM_TELEFONO`) VALUES (95815409,'1234','Elsira Puga Gallardo','944067452');
INSERT INTO `alumnos` (`ALM_DNI`,`ALM_PASSWORD`,`ALM_NOMBRE`,`ALM_TELEFONO`) VALUES (96059787,'1234','Rina Valladares Domínquez','943215432');
INSERT INTO `alumnos` (`ALM_DNI`,`ALM_PASSWORD`,`ALM_NOMBRE`,`ALM_TELEFONO`) VALUES (96756330,'1234','Celinda Caldera Cedillo','945392046');

/*
-- Query: SELECT * FROM proyectoiso3.profesores
LIMIT 0, 1000

-- Date: 2012-11-14 10:23
*/
INSERT INTO `profesores` (`PROF_ID`,`PROF_DNI`,`PROF_PASSWORD`,`PROF_NOMBRE`,`PROF_TFNO`,`PROF_EMAIL`,`PROF_DESPACHO`) VALUES (1,80409525,'1234','Kyle Price','987647543','KylePrice@dayrep.com','1A');
INSERT INTO `profesores` (`PROF_ID`,`PROF_DNI`,`PROF_PASSWORD`,`PROF_NOMBRE`,`PROF_TFNO`,`PROF_EMAIL`,`PROF_DESPACHO`) VALUES (2,81880980,'1234','Jouni Reinikainen','687609867','JouniReinikainen@teleworm.us','1B');
INSERT INTO `profesores` (`PROF_ID`,`PROF_DNI`,`PROF_PASSWORD`,`PROF_NOMBRE`,`PROF_TFNO`,`PROF_EMAIL`,`PROF_DESPACHO`) VALUES (3,65299037,'1234','Abdallah Márquez Aguayo','984172645','AbdallahMrquezAguayo@dayrep.com','2A');
INSERT INTO `profesores` (`PROF_ID`,`PROF_DNI`,`PROF_PASSWORD`,`PROF_NOMBRE`,`PROF_TFNO`,`PROF_EMAIL`,`PROF_DESPACHO`) VALUES (4,57283343,'1234','Frederic Godoy Comejo','658493612','FredericGodoyComejo@teleworm.us','2B');
INSERT INTO `profesores` (`PROF_ID`,`PROF_DNI`,`PROF_PASSWORD`,`PROF_NOMBRE`,`PROF_TFNO`,`PROF_EMAIL`,`PROF_DESPACHO`) VALUES (5,31695763,'1234','Charline Dastous','651428503','CharlineDastous@dayrep.com','3Z');

/*
-- Query: SELECT * FROM proyectoiso3.asignaturas
LIMIT 0, 1000

-- Date: 2012-11-14 10:21
*/
INSERT INTO `asignaturas` (`ASIGN_ID`,`ASIGN_CODIGO`,`ASIGN_NOMBRE`,`ASIGN_CREDITOS`,`PROF_ID`) VALUES (1,1,'Álgebra',6,3);
INSERT INTO `asignaturas` (`ASIGN_ID`,`ASIGN_CODIGO`,`ASIGN_NOMBRE`,`ASIGN_CREDITOS`,`PROF_ID`) VALUES (2,2,'Cálculo',9,2);
INSERT INTO `asignaturas` (`ASIGN_ID`,`ASIGN_CODIGO`,`ASIGN_NOMBRE`,`ASIGN_CREDITOS`,`PROF_ID`) VALUES (3,3,'Programación',12,1);
INSERT INTO `asignaturas` (`ASIGN_ID`,`ASIGN_CODIGO`,`ASIGN_NOMBRE`,`ASIGN_CREDITOS`,`PROF_ID`) VALUES (4,4,'Metodología de la programación',6,4);
INSERT INTO `asignaturas` (`ASIGN_ID`,`ASIGN_CODIGO`,`ASIGN_NOMBRE`,`ASIGN_CREDITOS`,`PROF_ID`) VALUES (5,5,'Sistemas operativos',9,5);

/*
-- Query: SELECT * FROM proyectoiso3.unidades
LIMIT 0, 1000

-- Date: 2012-11-14 10:23
*/
INSERT INTO `unidades` (`UD_ID`,`UD_ACRONIMO`,`UD_TITULO`,`UD_CONTENIDO`,`ASIGN_ID`) VALUES (1,'ALG-UD2','Espacios vectoriales euclideos','Conocer y comprender los conceptos básicos de la teoría de espacios vectoriales de dimensión finita. Describir los espacios vectoriales: \'conjunto de las matrices rectangulares de m filas y n columnas\', \'conjunto de los polinomios de grado menor ó igual que n\', \'conjunto de las funciones reales de variable real continuas en un dominio real\'. ',1);
INSERT INTO `unidades` (`UD_ID`,`UD_ACRONIMO`,`UD_TITULO`,`UD_CONTENIDO`,`ASIGN_ID`) VALUES (2,'ALG-UD1','Estructuras algebraicas','Desde los conceptos de conjunto y relación se define una estructura algebraica. Su clasificación se hace en función de las diferentes propiedades que puedan satisfacer las leyes de composición implicadas, haciendo relación a las diversas aplicaciones en el campo de la ingeniería.',1);
INSERT INTO `unidades` (`UD_ID`,`UD_ACRONIMO`,`UD_TITULO`,`UD_CONTENIDO`,`ASIGN_ID`) VALUES (3,'CALC-UD2','Ecuaciones diferenciales de orden superior','Se generaliza el concepto de ecuación diferencial ordinaria a un orden distinto de la unidad, caracterizando, en particular, las lineales (por las aplicaciones prácticas que encuentran). Se estudia el espacio de soluciones: resolviendo la ecuación homogénea y buscando una solución particular (bien por el método de variación de parámetros bien con el método de los coeficientes indeterminados).',2);
INSERT INTO `unidades` (`UD_ID`,`UD_ACRONIMO`,`UD_TITULO`,`UD_CONTENIDO`,`ASIGN_ID`) VALUES (4,'CALC-UD1','Ecuaciones diferenciales de primer orden','Se caracteriza la ecuación diferencial ordinaria de primer orden. A continuación se estudia la estructura del espacio de soluciones, considerando la correspondiente casuística, que interviene en su resolución. Finalmente, se realiza la aplicación a problemas de valor inicial en situaciones prácticas concretas.',2);
INSERT INTO `unidades` (`UD_ID`,`UD_ACRONIMO`,`UD_TITULO`,`UD_CONTENIDO`,`ASIGN_ID`) VALUES (5,'PRO-UD1','Introducción','Este tema es básicamente introductorio y se centra en explicar qué es la programación, cuáles son los objetivos de la programación, la importancia del algoritmo, cuáles son las fases de la programación (especificación, diseño del algoritmo, escritura del programa y prueba). Se introducen también distintos lenguajes de programación y sus características',3);
INSERT INTO `unidades` (`UD_ID`,`UD_ACRONIMO`,`UD_TITULO`,`UD_CONTENIDO`,`ASIGN_ID`) VALUES (6,'PRO-UD2','Conceptos básicos de programación','A lo largo de este tema se explora la escritura de algoritmos utilizando pseudocódigo. Así pues se ven expresiones, instrucciones básicas, estructuras de control, utilización de subprogramas, y por último algoritmos básicos de tratamiento de secuencias.',3);
INSERT INTO `unidades` (`UD_ID`,`UD_ACRONIMO`,`UD_TITULO`,`UD_CONTENIDO`,`ASIGN_ID`) VALUES (7,'MP-UD2','Variación de programas','El sistema formal de Hoare.',4);
INSERT INTO `unidades` (`UD_ID`,`UD_ACRONIMO`,`UD_TITULO`,`UD_CONTENIDO`,`ASIGN_ID`) VALUES (8,'MP-UD1','Especificación y documentación de programas','Especificación formal pre-post.',4);
INSERT INTO `unidades` (`UD_ID`,`UD_ACRONIMO`,`UD_TITULO`,`UD_CONTENIDO`,`ASIGN_ID`) VALUES (9,'SO-UD2','Desarrollo y Carga de Programas de C en Memoria: Librerías estáticas y dináminas.','Carga y ubicación de programas en sistemas con uno o varios programas en memoria. Direccionamiento físico y virtual. Desarrollo de librería estáticas y dinámicas.Librerías de enlace dinámico. Llamadas al sistema operativo relacionadas con la carga de programas y la gestión de la memoria. Prácticas: monitorización de consumo de memoria , manejo del Lenguaje C, uso de funciones de librería y ficheros cabecera , Uso de compilador: gcc, crear librerías dinámicas y estáticas , gestionar los proyectos con make',5);
INSERT INTO `unidades` (`UD_ID`,`UD_ACRONIMO`,`UD_TITULO`,`UD_CONTENIDO`,`ASIGN_ID`) VALUES (10,'SO-UD1','Gestión Sistema de Ficheros e Interprete Comandos','Concepto de sistema de ficheros y sus mecanismos de representación.Definición de sistema multiusuario. Tipos de usuarios, modos de acceso y dominios de protección. Mecanismos básicos de gestión de la protección de accesos en sistemas centralizados. Llamadas al sistema relacionadas con la protección de accesos y la seguridad. Prácticas: uso de redirecciones desde el Shell, programar ejemplos de entrada-salida. Prácticas: Manejo del Sistema de Ficheros, manejo del derechos de acceso, redireccionamiento y tuberías , montaje, programar ... desde el Shell.',5);

/*
-- Query: SELECT * FROM proyectoiso3.matriculado
LIMIT 0, 1000

-- Date: 2012-11-14 10:22
*/
INSERT INTO `matriculado` (`ALM_DNI`,`ASIGN_ID`) VALUES (1067499,2);
INSERT INTO `matriculado` (`ALM_DNI`,`ASIGN_ID`) VALUES (13940688,3);
INSERT INTO `matriculado` (`ALM_DNI`,`ASIGN_ID`) VALUES (20686524,3);
INSERT INTO `matriculado` (`ALM_DNI`,`ASIGN_ID`) VALUES (23361291,2);
INSERT INTO `matriculado` (`ALM_DNI`,`ASIGN_ID`) VALUES (23361291,4);
INSERT INTO `matriculado` (`ALM_DNI`,`ASIGN_ID`) VALUES (31833384,1);
INSERT INTO `matriculado` (`ALM_DNI`,`ASIGN_ID`) VALUES (31833384,3);
INSERT INTO `matriculado` (`ALM_DNI`,`ASIGN_ID`) VALUES (32342151,2);
INSERT INTO `matriculado` (`ALM_DNI`,`ASIGN_ID`) VALUES (32342151,4);
INSERT INTO `matriculado` (`ALM_DNI`,`ASIGN_ID`) VALUES (40097371,2);
INSERT INTO `matriculado` (`ALM_DNI`,`ASIGN_ID`) VALUES (60522675,1);
INSERT INTO `matriculado` (`ALM_DNI`,`ASIGN_ID`) VALUES (66881939,5);
INSERT INTO `matriculado` (`ALM_DNI`,`ASIGN_ID`) VALUES (78405443,1);
INSERT INTO `matriculado` (`ALM_DNI`,`ASIGN_ID`) VALUES (92878586,3);
INSERT INTO `matriculado` (`ALM_DNI`,`ASIGN_ID`) VALUES (92878586,5);
INSERT INTO `matriculado` (`ALM_DNI`,`ASIGN_ID`) VALUES (93925891,4);
INSERT INTO `matriculado` (`ALM_DNI`,`ASIGN_ID`) VALUES (95815409,5);
INSERT INTO `matriculado` (`ALM_DNI`,`ASIGN_ID`) VALUES (96059787,4);
INSERT INTO `matriculado` (`ALM_DNI`,`ASIGN_ID`) VALUES (96756330,1);
INSERT INTO `matriculado` (`ALM_DNI`,`ASIGN_ID`) VALUES (96756330,5);

/*
-- Query: SELECT * FROM proyectoiso3.evaluaciones
LIMIT 0, 1000

-- Date: 2012-11-14 10:22
*/
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (1,'Evaluación de Álgebra para Pavel Benavidez Moreno',7.8,1,78405443);
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (2,'Evaluación de Álgebra para Akemi Briones Parra',5,1,60522675);
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (3,'Evaluación de Programación para Libia Barrientos Escobar',5,3,31833384);
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (4,'Evaluación de Álgebra para Libia Barrientos Escobar',6.8,1,31833384);
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (5,'Evaluación de Cálculo para Fedor Cadena Serrato',7,2,40097371);
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (6,'Evaluación de Cálculo para Leslie Jurado Naranjo',1.5,2,1067499);
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (7,'Evaluación de Metodología de la programación para Leslie Jurado Naranjo',7.9,4,1067499);
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (8,'Evaluación de Cálculo para Ara Tórrez Oquendo',5,2,23361291);
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (9,'Evaluación de Programación para Joscio Argüello Nevarez',9,3,20686524);
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (10,'Evaluación de Programación para Pacífico Sánchez Escobedo',8.4,3,13940688);
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (11,'Evaluación de Programación para Esaú Regalado Caraballo',3.6,3,92878586);
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (12,'Evaluación de Sistemas operativos para Esaú Regalado Caraballo',7,5,92878586);
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (13,'Evaluación de Metodología de la programación para Rina Valladares Domínquez',3.2,4,96059787);
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (14,'Evaluación de Metodología de la programación para Maclovio Salcedo Enríquez',9.5,4,93925891);
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (15,'Evaluación de Cálculo para Amilcar Madrigal Menchaca',6,2,32342151);
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (16,'Evaluación de Metodología de la programación para Amilcar Madrigal Menchaca',7,4,32342151);
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (17,'Evaluación de Sistemas operativos para Elsira Puga Gallardo',7.5,5,95815409);
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (18,'Evaluación de Sistemas operativos para Fedor Cadena Serrato',4,5,66881939);
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (19,'Evaluación de Sistemas operativos para Celinda Caldera Cedillo',9,5,96756330);
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (20,'Evaluación de Álgebra para Celinda Caldera Cedillo',3.1,1,96756330);