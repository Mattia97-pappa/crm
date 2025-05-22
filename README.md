Applicazione web fatta con Spring framework(Security, MVC, SpringBoot, JPA)



Clonare progetto:


```
git clone https://github.com/Mattia97-pappa/crm.git
cd crm
```


Per accedere creare la tabella in questione per accedere come operatore: 

```
CREATE TABLE `operatore` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `cognome` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `ruolo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
```

E la tabella cliente per i clienti:



```
CREATE TABLE `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `cognome` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `azienda` varchar(255) DEFAULT NULL,
  `operatoreid` int(11) DEFAULT NULL,
  `citta` varchar(255) DEFAULT NULL,
  `settore` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `stato` varchar(255) DEFAULT 'Attivo',
  PRIMARY KEY (`id`),
  KEY `operatore_id` (`operatoreid`),
  CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`operatoreid`) REFERENCES `operatore` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
```



Sistemare anche le application.properties (ho utilizzato mariadb come database)


```
# DATASOURCE (DataSourceAutoConfiguration & DataSourceProperties)
spring.datasource.url=jdbc:mariadb://localhost:3306/crm
spring.datasource.username=root
spring.datasource.password=blackfriday

# Hibernate

# The SQL dialect makes Hibernate generate better SQL for the chosen database
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MariaDBDialect

# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.show-sql=false
spring.jpa.hibernate.ddl-auto=update
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl

logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type=TRACE
```
