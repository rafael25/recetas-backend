CREATE TABLE recetas (
	id INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(240),
	descripcion VARCHAR(300),
	ingredientes TEXT,
	preparacion TEXT,
	tiempo_prep INTEGER,
	rendimiento VARCHAR(60)
);

CREATE TABLE categorias (
	id INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(120)
);

CREATE TABLE categoria_receta (
	id_receta INTEGER UNSIGNED NOT NULL,
	id_categoria INTEGER UNSIGNED NOT NULL,

	CONSTRAINT `fk_receta_categoria` FOREIGN KEY (`id_receta`) REFERENCES `recetas` (`id`),
	CONSTRAINT `fk_categoria_receta` FOREIGN KEY (`id_categoria`) REFERENCES `categorias` (`id`)
);

CREATE TABLE imagenes (
	id INTEGER UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	url VARCHAR(300),
	id_receta INTEGER UNSIGNED NOT NULL,

	CONSTRAINT FOREIGN KEY (id_receta) REFERENCES recetas (id)
);
