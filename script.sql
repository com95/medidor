CREATE DATABASE IngSoft;
USE IngSoft;

CREATE TABLE Modelos (CodigoModelo int NOT NULL AUTO_INCREMENT, Nombre varchar(32), PRIMARY KEY (CodigoModelo));
CREATE TABLE Caracteristicas (CodigoCaracteristica int NOT NULL AUTO_INCREMENT, CodigoModelo int, Nombre varchar(64), PRIMARY KEY (CodigoCaracteristica), FOREIGN KEY (CodigoModelo) REFERENCES Modelos(CodigoModelo));
CREATE TABLE SubCaracteristicas (CodigoSubCaracteristica int NOT NULL AUTO_INCREMENT, CodigoCaracteristica int, Nombre varchar(64), PRIMARY KEY (CodigoSubCaracteristica), FOREIGN KEY (CodigoCaracteristica) REFERENCES Caracteristicas(CodigoCaracteristica));
CREATE TABLE Metricas (CodigoMetrica int NOT NULL AUTO_INCREMENT, CodigoSubCaracteristica int, Nombre varchar(64), Proposito varchar(255), EscalaMedicion varchar(16), TipoMedida varchar(32), Estado Bool, Formula varchar(64), ValorOptimo Double, PRIMARY KEY (CodigoMetrica), FOREIGN KEY (CodigoSubCaracteristica) REFERENCES SubCaracteristicas(CodigoSubCaracteristica));

INSERT INTO Modelos VALUES(DEFAULT,'ISO 91-26');
INSERT INTO Modelos VALUES(DEFAULT,'MCCALL');
INSERT INTO Modelos VALUES(DEFAULT,'PERUANO');

INSERT INTO Caracteristicas VALUES(DEFAULT,1,'FUNCIONABILIDAD');
INSERT INTO Caracteristicas VALUES(DEFAULT,1,'FIABILIDAD');
INSERT INTO Caracteristicas VALUES(DEFAULT,1,'USABILIDAD');
INSERT INTO Caracteristicas VALUES(DEFAULT,1,'EFICIENCIA');
INSERT INTO Caracteristicas VALUES(DEFAULT,1,'MANTENIBILIDAD');
INSERT INTO Caracteristicas VALUES(DEFAULT,1,'PORTABILIDAD');
INSERT INTO Caracteristicas VALUES(DEFAULT,2,'CORRECCION');
INSERT INTO Caracteristicas VALUES(DEFAULT,2,'FIABILIDAD');
INSERT INTO Caracteristicas VALUES(DEFAULT,2,'EFICACIA');
INSERT INTO Caracteristicas VALUES(DEFAULT,2,'INTEGRIDAD');
INSERT INTO Caracteristicas VALUES(DEFAULT,2,'FACILIDAD DE MANTENIMIENTO');
INSERT INTO Caracteristicas VALUES(DEFAULT,2,'FLEXIBILIDAD');
INSERT INTO Caracteristicas VALUES(DEFAULT,2,'PORTABILIDAD');
INSERT INTO Caracteristicas VALUES(DEFAULT,2,'REUSABILIDAD');
INSERT INTO Caracteristicas VALUES(DEFAULT,2,'INTEROPERABILIDAD');
INSERT INTO Caracteristicas VALUES(DEFAULT,3,'USABILIDAD');
INSERT INTO Caracteristicas VALUES(DEFAULT,3,'FUNCIONALIDAD');
INSERT INTO Caracteristicas VALUES(DEFAULT,3,'FIABILIDAD');

INSERT INTO SubCaracteristicas VALUES(DEFAULT,1,'ADECUACION');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,1,'EXACTITUD');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,1,'INTEROPERABILIDAD');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,1,'CONFORMIDAD DELA CONFIABILIDAD');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,2,'MADUREZ');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,2,'TOLERANCIA A FALLAS');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,2,'RECUPERACION');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,2,'CONFORMIDAD DE CONFIABILIDAD');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,3,'ENTENDIBILIDAD');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,3,'APRENDIBILIDAD');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,3,'OPERATIBILIDAD');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,3,'ATRACTIVIDAD');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,3,'CONFIABILIDAD DE LA USABILIDAD');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,4,'COMPORTAMIENTO EN EL TIEMPO');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,4,'RECURSOS UTILIZADOS');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,4,'CONFIABILIDAD DE LA EFICIENCIA');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,5,'ANALIZABILIDAD');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,5,'CAMBIABILIDAD');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,5,'ESTABILIDAD');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,5,'EXAMINABILIDAD');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,5,'CONFORMIDAD DE LA MANTENIBILIDAD');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,6,'ADAPTABILIDAD');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,6,'INSTALABILIDAD');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,6,'COEXISTENCIA');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,6,'REEEMPLAZABILIDAD');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,6,'CONFORMIDAD DE PORTABILIDAD');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,7,'COMPLETITUD');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,7,'FACILIDAD DE TRAZA');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,7,'CONSISTENCIA');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,8,'EXACTITUD');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,8,'CONCISION');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,8,'TOLERANCIA A ERRORES');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,8,'MODULARIDAD');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,8,'SIMPLICIDAD');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,9,'FACILIDAD DE OPERACION');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,9,'EFICIENCIA EN LA EJECUCION');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,10,'FACILIDAD DE AUDITORIA');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,10,'INSTRUMENTACION');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,10,'SEGURIDAD');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,11,'AUTO-DOCUMENTACION');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,12,'FACILIDAD DE EXPANSION');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,12,'GENERALIDAD');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,13,'INDEPENDENCIA DEL HARDWARE');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,14,'INDEPENDENCIA DEL SISTEMA');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,15,'ESTANDARIZACION EN LOS DATOS');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,15,'NORMALIZACIÓN DE LAS COMUNICACIONES');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,16,'APLICABILIDAD');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,17,'CONFROMIDAD DE FUNCIONALIDAD');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,18,'CONFORMIDAD DE MADUREZ');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,18,'CONFORMIDAD DE TOLERANCIA A FALLAS');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,18,'RECUPERABILIDAD');
INSERT INTO SubCaracteristicas VALUES(DEFAULT,18,'CONFORMIDAD DE CONFIABILIDAD');


INSERT INTO Metricas VALUES(DEFAULT,1,'ADECUACION FUNCIONAL','¿Cuán adecuadas son las funciones evaluadas?','Absoluta','cantidad/cantidad',0,'1-$/$',1.0);
INSERT INTO Metricas VALUES(DEFAULT,1,'COMPLETITUD E IMPLEMENTACION FUNCIONAL','¿Qué tan completa está la implementación de acuerdo a las especificaciones de requerimientos?','Absoluta','cantidad/cantidad',0,'1-$/$',1.0);
INSERT INTO Metricas VALUES(DEFAULT,1,'COBERTURA E IMPLEMENTACIÓN FUNCIONAL','¿Cuán correcta es la implementación funcional?','Absoluta','cantidad/cantidad',0,'1-$/$',1.0);
INSERT INTO Metricas VALUES(DEFAULT,1,'VOLATILIDAD','¿Qué tan estable es la especificación funcional después de entrar en operación?','Absoluta','cantidad/cantidad',0,'1-$/$',1.0);
INSERT INTO Metricas VALUES(DEFAULT,2,'EXACTITUD ESPERADA','¿Las diferencias entre los resultados actuales y los esperados son razonablemente aceptables?','Radio','cantidad/tiempo',0,'$/$',0);
INSERT INTO Metricas VALUES(DEFAULT,2,'EXACTITUD COMPUTACIONAL','¿Con qué frecuencia los usuarios finales se encuentran con resultados inexactos?','Radio','cantidad/tiempo',0,'$/$',0);
INSERT INTO Metricas VALUES(DEFAULT,2,'PRECISION','¿Con qué frecuencia los usuarios finales encuentran resultados con una precisión inadecuada?','Radio','cantidad/tiempo',0,'$/$',0);
INSERT INTO Metricas VALUES(DEFAULT,3,'INTERCAMBIABILIDAD DE DATOS','¿Con qué frecuencia el usuario final no logra intercambiar datos entre el software destino y otro software?','Absoluta','cantidad/cantidad',0,'1-$/$',0);
INSERT INTO Metricas VALUES(DEFAULT,4,'CONFORMIDAD DE FUNCIONALIDAD','¿Cuán conforme es la funcionalidad del producto para aplicar regulaciones, normas y convenciones?','Absoluta','cantidad/cantidad',0,'1-$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,5,'DENSIDAD DE FALLOS CONTRA CASOS DE PRUEBA','¿Cuántas fallas fueron detectadas durante el periodo de prueba definido?','Absoluta','cantidad/cantidad',0,'$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,5,'FALLOS RESUELTOS','¿Cuántas condiciones de fallo se han resuelto?','Absoluta','cantidad/cantidad',0,'$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,6,'EVITANDO OPERACIONES INCORRECTAS','Evitando operaciones incorrectas','Absoluta','cantidad/cantidad',0,'$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,7,'MEDIDA DE TIEMPO DE INACTIVIDAD','¿Cuál es el tiempo promedio que el sistema se queda disponible cuando se produce un fallo antes la respuesta en marcha?','Proporción','tiempo/cantidad',0,'$/$',0);
INSERT INTO Metricas VALUES(DEFAULT,7,'RESTAURABILIDAD','¿Qué tan capaz es el producto en sí mismo después de la restauración del evento anormal a solicitud?','Absoluta','cantidad/cantidad',0,'$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,8,'CONFORMIDAD DE CONFIABILIDAD','¿Cómo es compatible con la fiabilidad del producto a los reglamentos, normas y convenciones?','Absoluta','cantidad/cantidad',0,'1-$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,9,'DEMOSTRACION DE ACCESIBILIDAD','¿Qué proporción de las demostraciones / tutoriales puede el usuario acceder?','Absoluta','cantidad/cantidad',0,'$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,10,'DEMOSTRACION DE ACCESIBILIDAD','¿Qué proporción de las demostraciones / tutoriales puede el usuario acceder?','Proporción','tiempo',0,'$',0);
INSERT INTO Metricas VALUES(DEFAULT,10,'EFECTIVIDAD DE LA DOCUMENTACION DEL USUARIO Y/O SISTEMA DE AYUDA','¿Qué proporción de tareas se puede completar correctamente después de usar la documentación de usuario y/o sistema de ayuda?','Absoluta','cantidad/cantidad',0,'$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,10,'EFECTIVIDAD DE LA DOCUMENTACION DEL USUARIO Y/O SISTEMA EN USO','¿Qué proporción de las funciones se pueden usar correctamente después de leer la documentación o el uso de sistemas de ayuda?','Absoluta','cantidad/cantidad',0,'$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,11,'CORRECION DE ERRORES DE USUARIO','¿Con qué frecuencia lo hace con éxito el usuario los errores de entrada correctos?','Absoluta','cantidad/cantidad',0,'$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,12,'PERSONALIZAR LA APARIENCIA DE INTERFAZ','¿Qué proporción de elementos de la interfaz se puede personalizar en apariencia a la satisfacción del usuario?','Absoluta','cantidad/cantidad',0,'$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,13,'CONFIABILIAD DE LA USABILIDAD','¿Cómo completamente el software no se adhiere a las normas, convenciones, guías de estilo o reglamentos relacionados con la usabilidad?','Absoluta','cantidad/cantidad',0,'$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,14,'RENDIMIENTO','¿Cuántas tareas se puede realizar con éxito durante un periodo determinado tiempo?','Absoluta','cantidad/tiempo',0,'$/$',0);
INSERT INTO Metricas VALUES(DEFAULT,14,'E/S ERRORES RELACIONADOS','¿Con qué frecuencia el usuario se encuentra con problemas en las operaciones del dispositivo de E/S relacionada?','Absoluta','cantidad/tiempo',0,'$/$',0);
INSERT INTO Metricas VALUES(DEFAULT,15,'E/S UTILIZACION DE DISPOSITIVOS','¿Es la utilización de los dispositivos de E / S demasiado alto, provocando ineficiencias?','Absoluta','tiempo/tiempo',0,'$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,15,'E/S ERRORES RELACIONADOS','¿Con qué frecuencia el usuario se encuentra con problemas en las operaciones del dispositivo de E/S relacionada?','Proporción','cantidad/tiempo',0,'$/$',0);
INSERT INTO Metricas VALUES(DEFAULT,16,'CONFIABILIDAD DE LA EFICIENCIA','¿Cómo es compatible con la eficacia del producto a los reglamentos, normas y convenciones?','Absoluta','cantidad/cantidad',0,'1-$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,17,'CAPACIDAD DE SEGUIMIENTO DE AUDITORÍA','¿Puede el usuario identificar operación específica que causó el fracaso? ¿Puede el mantenedor encontrar fácilmente operaciones específicas que causó el fracaso?','Absoluta','cantidad/cantidad',0,'$/$',0);
INSERT INTO Metricas VALUES(DEFAULT,18,'REGISTRABILIDAD DE CAMBIOS','¿Se registran adecuadamente los cambios a la especificación y a los módulos con comentarios en el código?','Absoluta','cantidad/cantidad',0,'$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,19,'CAMBIO DE PORCENTAJE DE ÉXITO','¿Puede el usuario operar el sistema de software sin fallos después de mantenimiento? ','Proporción','cantidad/tiempo',0,'$/$',0);
INSERT INTO Metricas VALUES(DEFAULT,20,'DISPONIBLIDAD DE FUNCIÓN DE PRUEBA INCORPORADA','¿Pueden los usuarios y mantenedor realizar fácilmente pruebas de funcionamiento sin la preparación de instalación de una prueba adicional?','Absoluta','cantidad/tiempo',0,'$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,21,'CUMPLIMIENTO DE MANTENIBILIDAD','¿Cómo es compatible con la capacidad de mantenimiento del producto a los reglamentos, normas y convenciones?','Absoluta','cantidad/cantidad',0,'1-$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,22,'ADAPTABILIDAD DE ESTRUCTURAS DE DATOS','¿Puede el usuario o el mantenedor adaptarse al software para conjuntos de datos en un nuevo entorno?','Absoluta','cantidad/cantidad',0,'$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,22,'ADAPTABILIDAD DE AMBIENTAL','¿Puede el usuario o el mantenedor adaptarse al software para el medio ambiente? ','Absoluta','cantidad/cantidad',0,'$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,22,'FACILIDAD DE USO DE PORTAR','¿Es el sistema de software lo suficientemente capaz de adaptarse al ambiente de operación?','Absoluta','tiempo',0,'$',0);
INSERT INTO Metricas VALUES(DEFAULT,23,'FÁCIL DE INSTALAR','¿Puede el usuario o el mantenedor instalar fácilmente software para un ambiente de operación?','Absoluta','cantidad/cantidad',0,'$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,23,'REPROCESAMIENTO','¿Puede usuario o mantenedor fácilmente volver a intentar la configuración de instalación de software?','Absoluta','cantidad/cantidad',0,'1-$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,24,'DISPONIBILIDAD DE COEXISTENCIA','¿Con qué frecuencia el usuario se encuentra con todas las restricciones o fallos inesperados cuando se opera simultáneamente con otro software?','Proporción','cantidad/tiempo',0,'$/$',0);
INSERT INTO Metricas VALUES(DEFAULT,25,'CONTINUO USO DE DATOS','¿Pueden usuario o mantenedor fácilmente seguir utilizando los mismos datos después de reemplazar este software para la anterior? ','Absoluta','cantidad/cantidad',0,'$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,26,'CONFORMIDAD DE PORTABILIDAD','¿Qué tan conforme es la Portabilidad del producto con regulaciones, estándares y convenciones aplicables?','Absoluta','cantidad/cantidad',0,'$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,27,'CLARIDAD DE REQUISITOS','Identidificar el porcentaje de requisistos desarrollados',' ',' ',0,'$/$',1.0);
INSERT INTO Metricas VALUES(DEFAULT,27,'INDICE DE MADUREZ','Medir la evolución de software',' ',' ',0,'($-($+$+$))/$',1.0);
INSERT INTO Metricas VALUES(DEFAULT,28,'FACILIDAD DE SEGUIMIENTO','Medir la facilidad de seguimiento',' ',' ',0,'$/$',1.0);
INSERT INTO Metricas VALUES(DEFAULT,29,'NIVEL DE CORRELACION ENTRE DOCUMENTACION Y CODIGO','Medir el grado de emparejamiento entre documentación y coigo',' ',' ',0,'$/$',1.0);
INSERT INTO Metricas VALUES(DEFAULT,30,'GRADO DE CORRECTITUD','Medir el grado de correco de exactitud mediante la identificación de módulos con defectos',' ',' ',0,'1-$/$',1.0);
INSERT INTO Metricas VALUES(DEFAULT,30,'GRADO DE CORRECTO FUNCIONAMIENTO','Medir el grado de correcto funcionamiento mediante el complemento de defectos',' ',' ',0,'1-(10*$+5*$+3*$+2*$+$)/(10*$)',0);
INSERT INTO Metricas VALUES(DEFAULT,30,'PROBABILIDAD DE BUENA PERFORMANCE','Medir la probabilidad de un correcto funcionamiento',' ',' ',0,'1-$',1.0);
INSERT INTO Metricas VALUES(DEFAULT,31,'UNICIDAD DE LINEAS DE CODIGO','Medir la cantidad de lineas duplicadas, que consumen espacio y reducen eficiencia',' ',' ',0,'1-$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,31,'UNICIDAD DE BLOQUES','Medir la cantidad de lineas duplicadas, que consumen espacio y reducen eficiencia',' ',' ',0,'1-$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,31,'UNICIDAD DE ARCHIVOS','Medir la cantidad de lineas duplicadas, que consumen espacio y reducen eficiencia',' ',' ',0,'1-$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,32,'CONTROLABILIDAD','Medir el grado de control de errores',' ',' ',0,'$/$',1.0);
INSERT INTO Metricas VALUES(DEFAULT,33,'FLUJO DE INFORMACION','Medir el flujo de información',' ',' ',0,'($*$)^2',100);
INSERT INTO Metricas VALUES(DEFAULT,34,'INDICE DE MANTENIBILIDAD','Medir el grado de facilidad con el que se puede hacer mantenimiento',' ',' ',0,'max(0,(171-5.2*log($)-0.23*$-16.2*log($))*100/17)',100);
INSERT INTO Metricas VALUES(DEFAULT,35,'FACILIDAD DE COMUNICACION EN LAS INTERFACES','Medir el grado de auto explicacion de los elementos de la interfaz',' ',' ',0,'$/$',1.0);
INSERT INTO Metricas VALUES(DEFAULT,35,'ENTENDIBILIDAD DE MENSAJES','Medir el grado de entendibilidad de los mensajes',' ',' ',0,'$/$',1.0);
INSERT INTO Metricas VALUES(DEFAULT,35,'ENTENDIBILIDAD DEL MANUAL','Medir el nivel de entendibilidad de la documentacion',' ',' ',0,'$/$',1.0);
INSERT INTO Metricas VALUES(DEFAULT,36,'GESTION DE MEMORIA DINAMICA','Esta es una métrica booleana que considera el uso de la gestión de memoria dinámica',' ',' ',0,'0',1);
INSERT INTO Metricas VALUES(DEFAULT,36,'ADECUADA INICIALIZACION DE VARIABLES','La inicialización de varibales durante la ejecución puede reducir eficiencia',' ',' ',0,'1-$/$',1.0);
INSERT INTO Metricas VALUES(DEFAULT,37,'FACILIDAD DE TESTIBILIDAD','Medir el grado de facilidad de testabilidad','Absoluta','',0,'$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,37,'FACILIDAD DE ENTENDIMIENTO','Medir el grado de fiabilidad de la documentación',' ',' ',0,'$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,38,'USO DE HERRAMIENTAS DE DESARROLLO','Medir el grado de control que se tiene haciendo uso de herramientas de desarrollo',' ',' ',0,'$/$',1.0);
INSERT INTO Metricas VALUES(DEFAULT,39,'GRADO DE CORRECTO FUNCIONAMIENTO','Medir el grado de correcto funcionamiento mediante el complemento de defectos',' ',' ',0,'1-(10*$+5*$+3*$+2*$+$)/(10*$)',1.0);
INSERT INTO Metricas VALUES(DEFAULT,39,'PROBABILIDAD DE BUENA PERFORMANCE','Medir la probabilidad de un correcto funcionamiento',' ',' ',0,'1-$',1.00);
INSERT INTO Metricas VALUES(DEFAULT,40,'COMPRENSION E INTEGRIDAD','Esta métrica mide la facilidad de compresión de un componente',' ',' ',0,'$/$',1.00);
INSERT INTO Metricas VALUES(DEFAULT,41,'NIVEL DE REUTILIZABILIDAD','Medir la independencia de componentes',' ',' ',0,'$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,42,'FLUJO DE INFORMACION','Medir el flujo de información',' ',' ',0,'($*$)^2',100);
INSERT INTO Metricas VALUES(DEFAULT,43,'CODIGO INDEPENDIENTE','El código que depende de la palabra o máquina o tamaño de la fuente es otro parámetro que hace que al software más dependiente en el hardware máquinas',' ',' ',0,'$/$',1.00);
INSERT INTO Metricas VALUES(DEFAULT,44,'FACILIDAD DE TRANSPORTE','Medir la facilidad de creación de un entorno',' ',' ',0,'$/$',1.00);
INSERT INTO Metricas VALUES(DEFAULT,45,'GRADO DE CORRECTITUD DE NOMBRAMIENTO DE METODOS','Esta métrica mide el grado de conformidad con las normas pertinentes para la identificación de métodos',' ',' ',0,'1-$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,45,'GRADO DE CORRECTITUD DE DEFINICION DE CLASES','Esta métrica mide el grado de conformidad con la definicón de clases',' ',' ',0,'1-$/$',1.00);
INSERT INTO Metricas VALUES(DEFAULT,45,'GRADO DE CUMPLIMIENTO DE NORMAS','Medir el grado e cumplimiento mediante el complemento de vulneraciones',' ',' ',0,'1-(10*$+5*$+3*$+2*$+$)/(10*$)',1.00);
INSERT INTO Metricas VALUES(DEFAULT,46,'ESTANDARIZACIÓN DE INTERFACE','Medir el grado de estandarización de interface','','',0,'$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,46,'FACILIDAD DE COMUNICACIÓN EN LAS INTERFACES','Medir el grado de auto explicación de los elementos de la interfaz','','',0,'$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,46,'ENTENDIBILIDAD DE MENSAJES','Medir el grado de entendibilidad de los mensajes','','',0,'$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,47,'ADECUACION FUNCIONAL','¿Cuán adecuadas son las funciones evaluadas?','Absoluta','cantidad/cantidad',0,'1-$/$',1.00);
INSERT INTO Metricas VALUES(DEFAULT,47,'INTEGRIDAD DE IMPLEMENTACION FUNCIONAL','¿Cuán completa está la implementación de acuerdo a las especificaciones de requerimientos?','Absoluta','cantidad/cantidad',0,'1-$/$',1.00);
INSERT INTO Metricas VALUES(DEFAULT,47,'COBERTURA DE IMPLEMENTACION FUNCIONAL','¿Cuán correcta es la implementación funcional?','Absoluta','cantidad/cantidad',0,'1-$/$',1.00);
INSERT INTO Metricas VALUES(DEFAULT,47,'VOLATILIDAD','¿Cuán estable es la especificación funcional después que entra en operación?','Absoluta','cantidad/cantidad',0,'1-$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,48,'CONFORMIDAD DE LA NORMA DE INTERFAZ','¿Cuán conforme son las interfaces respecto a las regulaciones, normas y convenciones?','Absoluta','cantidad/cantidad',0,'$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,49,'DENSIDAD ESTIMADA DEL ERROR LATENTE','¿Cuán problemas aún existentes pueden surgir como errores futuros?','Absoluta','cantidad/tamaño',0,'abs($-$)/$',0);
INSERT INTO Metricas VALUES(DEFAULT,49,'DENSIDAD DE FALLAS CONTRA CASOS DE PRUEBA','¿Cuántas fallas fueron detectadas durante el periodo de prueba definido?','Absoluta','cantidad/cantidad',0,'$/$',0);
INSERT INTO Metricas VALUES(DEFAULT,49,'RESOLUCIÓN DE FALLAS','¿Cuántas condiciones de falla son resueltas?','Absoluta','cantidad/cantidad',0,'$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,49,'ELIMINACIÓN DE FALLAS','¿Cuántas fallas han sido corregidas?','Absoluta','cantidad/cantidad',0,'$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,50,'PREVENCIÓN DE FALLAS','¿Cuántos tipos de errores fueron causados bajo el control para evitar fallas críticas y serias?','Absoluta','cantidad/cantidad',0,'$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,50,'PREVENCIÓN DE OPERACIÓN INCORRECTA','¿Cuántas funciones son implementadas con capacidad de prevención de operación incorrecta?','Absoluta','cantidad/cantidad',0,'$/$',1);
INSERT INTO Metricas VALUES(DEFAULT,51,'TIEMPO MEDIO DE RECUPERACIÓN','¿Cuál es el tiempo promedio que el sistema toma para completar la recuperación desde el inicio de la recuperación?','Ratio','cantidad/cantidad',0,'$/$',0);
INSERT INTO Metricas VALUES(DEFAULT,52,'CONFORMIDAD DE FIABILIDAD','¿Cuán conforme es la fiabilidad del producto a las regulaciones aplicables, normas y convenciones?','Absoluta','cantidad/cantidad',0,'1-$/$',0);