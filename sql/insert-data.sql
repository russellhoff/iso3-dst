/*
-- Query: SELECT * FROM proyectoiso3.alumnos
LIMIT 0, 1000

-- Date: 2012-11-14 10:21
*/
INSERT INTO `alumnos` (`ALM_DNI`,`ALM_PASSWORD`,`ALM_NOMBRE`,`ALM_TELEFONO`) VALUES (1067499,'1234','Leslie Jurado Naranjo','945295836');
INSERT INTO `alumnos` (`ALM_DNI`,`ALM_PASSWORD`,`ALM_NOMBRE`,`ALM_TELEFONO`) VALUES (13940688,'1234','Pac�fico S�nchez Escobedo','987098543');
INSERT INTO `alumnos` (`ALM_DNI`,`ALM_PASSWORD`,`ALM_NOMBRE`,`ALM_TELEFONO`) VALUES (20686524,'1234','Joscio Arg�ello Nevarez','987654687');
INSERT INTO `alumnos` (`ALM_DNI`,`ALM_PASSWORD`,`ALM_NOMBRE`,`ALM_TELEFONO`) VALUES (23361291,'1234','Ara T�rrez Oquendo','945295768');
INSERT INTO `alumnos` (`ALM_DNI`,`ALM_PASSWORD`,`ALM_NOMBRE`,`ALM_TELEFONO`) VALUES (31833384,'1234','Libia Barrientos Escobar','961529453');
INSERT INTO `alumnos` (`ALM_DNI`,`ALM_PASSWORD`,`ALM_NOMBRE`,`ALM_TELEFONO`) VALUES (32342151,'1234','Amilcar Madrigal Menchaca','987540914');
INSERT INTO `alumnos` (`ALM_DNI`,`ALM_PASSWORD`,`ALM_NOMBRE`,`ALM_TELEFONO`) VALUES (40097371,'1234','Andr� Baca Rael','946552957');
INSERT INTO `alumnos` (`ALM_DNI`,`ALM_PASSWORD`,`ALM_NOMBRE`,`ALM_TELEFONO`) VALUES (60522675,'1234','Akemi Briones Parra','934957355');
INSERT INTO `alumnos` (`ALM_DNI`,`ALM_PASSWORD`,`ALM_NOMBRE`,`ALM_TELEFONO`) VALUES (66881939,'1234','Fedor Cadena Serrato','965295463');
INSERT INTO `alumnos` (`ALM_DNI`,`ALM_PASSWORD`,`ALM_NOMBRE`,`ALM_TELEFONO`) VALUES (78405443,'1234','Pavel Benavidez Moreno','945039476');
INSERT INTO `alumnos` (`ALM_DNI`,`ALM_PASSWORD`,`ALM_NOMBRE`,`ALM_TELEFONO`) VALUES (92878586,'1234','Esa� Regalado Caraballo','910543276');
INSERT INTO `alumnos` (`ALM_DNI`,`ALM_PASSWORD`,`ALM_NOMBRE`,`ALM_TELEFONO`) VALUES (93925891,'1234','Maclovio Salcedo Enr�quez','987604326');
INSERT INTO `alumnos` (`ALM_DNI`,`ALM_PASSWORD`,`ALM_NOMBRE`,`ALM_TELEFONO`) VALUES (95815409,'1234','Elsira Puga Gallardo','944067452');
INSERT INTO `alumnos` (`ALM_DNI`,`ALM_PASSWORD`,`ALM_NOMBRE`,`ALM_TELEFONO`) VALUES (96059787,'1234','Rina Valladares Dom�nquez','943215432');
INSERT INTO `alumnos` (`ALM_DNI`,`ALM_PASSWORD`,`ALM_NOMBRE`,`ALM_TELEFONO`) VALUES (96756330,'1234','Celinda Caldera Cedillo','945392046');

/*
-- Query: SELECT * FROM proyectoiso3.profesores
LIMIT 0, 1000

-- Date: 2012-11-14 10:23
*/
INSERT INTO `profesores` (`PROF_ID`,`PROF_DNI`,`PROF_PASSWORD`,`PROF_NOMBRE`,`PROF_TFNO`,`PROF_EMAIL`,`PROF_DESPACHO`) VALUES (1,80409525,'1234','Kyle Price','987647543','KylePrice@dayrep.com','1A');
INSERT INTO `profesores` (`PROF_ID`,`PROF_DNI`,`PROF_PASSWORD`,`PROF_NOMBRE`,`PROF_TFNO`,`PROF_EMAIL`,`PROF_DESPACHO`) VALUES (2,81880980,'1234','Jouni Reinikainen','687609867','JouniReinikainen@teleworm.us','1B');
INSERT INTO `profesores` (`PROF_ID`,`PROF_DNI`,`PROF_PASSWORD`,`PROF_NOMBRE`,`PROF_TFNO`,`PROF_EMAIL`,`PROF_DESPACHO`) VALUES (3,65299037,'1234','Abdallah M�rquez Aguayo','984172645','AbdallahMrquezAguayo@dayrep.com','2A');
INSERT INTO `profesores` (`PROF_ID`,`PROF_DNI`,`PROF_PASSWORD`,`PROF_NOMBRE`,`PROF_TFNO`,`PROF_EMAIL`,`PROF_DESPACHO`) VALUES (4,57283343,'1234','Frederic Godoy Comejo','658493612','FredericGodoyComejo@teleworm.us','2B');
INSERT INTO `profesores` (`PROF_ID`,`PROF_DNI`,`PROF_PASSWORD`,`PROF_NOMBRE`,`PROF_TFNO`,`PROF_EMAIL`,`PROF_DESPACHO`) VALUES (5,31695763,'1234','Charline Dastous','651428503','CharlineDastous@dayrep.com','3Z');

/*
-- Query: SELECT * FROM proyectoiso3.asignaturas
LIMIT 0, 1000

-- Date: 2012-11-14 10:21
*/
INSERT INTO `asignaturas` (`ASIGN_ID`,`ASIGN_CODIGO`,`ASIGN_NOMBRE`,`ASIGN_CREDITOS`,`PROF_ID`) VALUES (1,1,'�lgebra',6,3);
INSERT INTO `asignaturas` (`ASIGN_ID`,`ASIGN_CODIGO`,`ASIGN_NOMBRE`,`ASIGN_CREDITOS`,`PROF_ID`) VALUES (2,2,'C�lculo',9,2);
INSERT INTO `asignaturas` (`ASIGN_ID`,`ASIGN_CODIGO`,`ASIGN_NOMBRE`,`ASIGN_CREDITOS`,`PROF_ID`) VALUES (3,3,'Programaci�n',12,1);
INSERT INTO `asignaturas` (`ASIGN_ID`,`ASIGN_CODIGO`,`ASIGN_NOMBRE`,`ASIGN_CREDITOS`,`PROF_ID`) VALUES (4,4,'Metodolog�a de la programaci�n',6,4);
INSERT INTO `asignaturas` (`ASIGN_ID`,`ASIGN_CODIGO`,`ASIGN_NOMBRE`,`ASIGN_CREDITOS`,`PROF_ID`) VALUES (5,5,'Sistemas operativos',9,5);

/*
-- Query: SELECT * FROM proyectoiso3.unidades
LIMIT 0, 1000

-- Date: 2012-11-14 10:23
*/
INSERT INTO `unidades` (`UD_ID`,`UD_ACRONIMO`,`UD_TITULO`,`UD_CONTENIDO`,`ASIGN_ID`) VALUES (1,'ALG-UD2','Espacios vectoriales euclideos','Conocer y comprender los conceptos b�sicos de la teor�a de espacios vectoriales de dimensi�n finita. Describir los espacios vectoriales: \'conjunto de las matrices rectangulares de m filas y n columnas\', \'conjunto de los polinomios de grado menor � igual que n\', \'conjunto de las funciones reales de variable real continuas en un dominio real\'. ',1);
INSERT INTO `unidades` (`UD_ID`,`UD_ACRONIMO`,`UD_TITULO`,`UD_CONTENIDO`,`ASIGN_ID`) VALUES (2,'ALG-UD1','Estructuras algebraicas','Desde los conceptos de conjunto y relaci�n se define una estructura algebraica. Su clasificaci�n se hace en funci�n de las diferentes propiedades que puedan satisfacer las leyes de composici�n implicadas, haciendo relaci�n a las diversas aplicaciones en el campo de la ingenier�a.',1);
INSERT INTO `unidades` (`UD_ID`,`UD_ACRONIMO`,`UD_TITULO`,`UD_CONTENIDO`,`ASIGN_ID`) VALUES (3,'CALC-UD2','Ecuaciones diferenciales de orden superior','Se generaliza el concepto de ecuaci�n diferencial ordinaria a un orden distinto de la unidad, caracterizando, en particular, las lineales (por las aplicaciones pr�cticas que encuentran). Se estudia el espacio de soluciones: resolviendo la ecuaci�n homog�nea y buscando una soluci�n particular (bien por el m�todo de variaci�n de par�metros bien con el m�todo de los coeficientes indeterminados).',2);
INSERT INTO `unidades` (`UD_ID`,`UD_ACRONIMO`,`UD_TITULO`,`UD_CONTENIDO`,`ASIGN_ID`) VALUES (4,'CALC-UD1','Ecuaciones diferenciales de primer orden','Se caracteriza la ecuaci�n diferencial ordinaria de primer orden. A continuaci�n se estudia la estructura del espacio de soluciones, considerando la correspondiente casu�stica, que interviene en su resoluci�n. Finalmente, se realiza la aplicaci�n a problemas de valor inicial en situaciones pr�cticas concretas.',2);
INSERT INTO `unidades` (`UD_ID`,`UD_ACRONIMO`,`UD_TITULO`,`UD_CONTENIDO`,`ASIGN_ID`) VALUES (5,'PRO-UD1','Introducci�n','Este tema es b�sicamente introductorio y se centra en explicar qu� es la programaci�n, cu�les son los objetivos de la programaci�n, la importancia del algoritmo, cu�les son las fases de la programaci�n (especificaci�n, dise�o del algoritmo, escritura del programa y prueba). Se introducen tambi�n distintos lenguajes de programaci�n y sus caracter�sticas',3);
INSERT INTO `unidades` (`UD_ID`,`UD_ACRONIMO`,`UD_TITULO`,`UD_CONTENIDO`,`ASIGN_ID`) VALUES (6,'PRO-UD2','Conceptos b�sicos de programaci�n','A lo largo de este tema se explora la escritura de algoritmos utilizando pseudoc�digo. As� pues se ven expresiones, instrucciones b�sicas, estructuras de control, utilizaci�n de subprogramas, y por �ltimo algoritmos b�sicos de tratamiento de secuencias.',3);
INSERT INTO `unidades` (`UD_ID`,`UD_ACRONIMO`,`UD_TITULO`,`UD_CONTENIDO`,`ASIGN_ID`) VALUES (7,'MP-UD2','Variaci�n de programas','El sistema formal de Hoare.',4);
INSERT INTO `unidades` (`UD_ID`,`UD_ACRONIMO`,`UD_TITULO`,`UD_CONTENIDO`,`ASIGN_ID`) VALUES (8,'MP-UD1','Especificaci�n y documentaci�n de programas','Especificaci�n formal pre-post.',4);
INSERT INTO `unidades` (`UD_ID`,`UD_ACRONIMO`,`UD_TITULO`,`UD_CONTENIDO`,`ASIGN_ID`) VALUES (9,'SO-UD2','Desarrollo y Carga de Programas de C en Memoria: Librer�as est�ticas y din�minas.','Carga y ubicaci�n de programas en sistemas con uno o varios programas en memoria. Direccionamiento f�sico y virtual. Desarrollo de librer�a est�ticas y din�micas.Librer�as de enlace din�mico. Llamadas al sistema operativo relacionadas con la carga de programas y la gesti�n de la memoria. Pr�cticas: monitorizaci�n de consumo de memoria , manejo del Lenguaje C, uso de funciones de librer�a y ficheros cabecera , Uso de compilador: gcc, crear librer�as din�micas y est�ticas , gestionar los proyectos con make',5);
INSERT INTO `unidades` (`UD_ID`,`UD_ACRONIMO`,`UD_TITULO`,`UD_CONTENIDO`,`ASIGN_ID`) VALUES (10,'SO-UD1','Gesti�n Sistema de Ficheros e Interprete Comandos','Concepto de sistema de ficheros y sus mecanismos de representaci�n.Definici�n de sistema multiusuario. Tipos de usuarios, modos de acceso y dominios de protecci�n. Mecanismos b�sicos de gesti�n de la protecci�n de accesos en sistemas centralizados. Llamadas al sistema relacionadas con la protecci�n de accesos y la seguridad. Pr�cticas: uso de redirecciones desde el Shell, programar ejemplos de entrada-salida. Pr�cticas: Manejo del Sistema de Ficheros, manejo del derechos de acceso, redireccionamiento y tuber�as , montaje, programar ... desde el Shell.',5);

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
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (1,'Evaluaci�n de �lgebra para Pavel Benavidez Moreno',7.8,1,78405443);
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (2,'Evaluaci�n de �lgebra para Akemi Briones Parra',5,1,60522675);
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (3,'Evaluaci�n de Programaci�n para Libia Barrientos Escobar',5,3,31833384);
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (4,'Evaluaci�n de �lgebra para Libia Barrientos Escobar',6.8,1,31833384);
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (5,'Evaluaci�n de C�lculo para Fedor Cadena Serrato',7,2,40097371);
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (6,'Evaluaci�n de C�lculo para Leslie Jurado Naranjo',1.5,2,1067499);
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (7,'Evaluaci�n de Metodolog�a de la programaci�n para Leslie Jurado Naranjo',7.9,4,1067499);
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (8,'Evaluaci�n de C�lculo para Ara T�rrez Oquendo',5,2,23361291);
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (9,'Evaluaci�n de Programaci�n para Joscio Arg�ello Nevarez',9,3,20686524);
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (10,'Evaluaci�n de Programaci�n para Pac�fico S�nchez Escobedo',8.4,3,13940688);
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (11,'Evaluaci�n de Programaci�n para Esa� Regalado Caraballo',3.6,3,92878586);
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (12,'Evaluaci�n de Sistemas operativos para Esa� Regalado Caraballo',7,5,92878586);
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (13,'Evaluaci�n de Metodolog�a de la programaci�n para Rina Valladares Dom�nquez',3.2,4,96059787);
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (14,'Evaluaci�n de Metodolog�a de la programaci�n para Maclovio Salcedo Enr�quez',9.5,4,93925891);
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (15,'Evaluaci�n de C�lculo para Amilcar Madrigal Menchaca',6,2,32342151);
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (16,'Evaluaci�n de Metodolog�a de la programaci�n para Amilcar Madrigal Menchaca',7,4,32342151);
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (17,'Evaluaci�n de Sistemas operativos para Elsira Puga Gallardo',7.5,5,95815409);
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (18,'Evaluaci�n de Sistemas operativos para Fedor Cadena Serrato',4,5,66881939);
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (19,'Evaluaci�n de Sistemas operativos para Celinda Caldera Cedillo',9,5,96756330);
INSERT INTO `evaluaciones` (`EVAL_ID`,`EVAL_CONCEPTO`,`EVAL_NOTA`,`ASIGN_ID`,`ALM_DNI`) VALUES (20,'Evaluaci�n de �lgebra para Celinda Caldera Cedillo',3.1,1,96756330);