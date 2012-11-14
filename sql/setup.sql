--
-- Create Database and Users
--

CREATE DATABASE IF NOT EXISTS proyectoiso3 DEFAULT CHARACTER SET latin1;
USE proyectoiso3;

GRANT ALTER, SELECT,INSERT,UPDATE,DELETE,CREATE,DROP
           ON proyectoiso3.*
           TO eside@'%'
           IDENTIFIED BY 'eside';

GRANT ALTER, SELECT,INSERT,UPDATE,DELETE,CREATE,DROP
           ON proyectoiso3.*
           TO eside@localhost
           IDENTIFIED BY 'eside';