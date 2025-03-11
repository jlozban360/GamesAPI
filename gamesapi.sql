CREATE DATABASE IF NOT EXISTS gamesapi_db;

USE gamesapi_db;

-- Tabla Desarrolladores
CREATE TABLE Desarrolladores (
     id INT AUTO_INCREMENT PRIMARY KEY,
     nombre VARCHAR(100) NOT NULL,
     pais VARCHAR(50)
);

-- Tabla Plataformas
CREATE TABLE Plataformas (
     id INT AUTO_INCREMENT PRIMARY KEY,
     nombre VARCHAR(100) NOT NULL
);

-- Tabla Juegos
CREATE TABLE Juegos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    genero VARCHAR(50),
    lanzamiento DATE,
    desarrollador_id INT,
    plataforma_id INT,
    FOREIGN KEY (desarrollador_id) REFERENCES Desarrolladores(id),
    FOREIGN KEY (plataforma_id) REFERENCES Plataformas(id)
);

INSERT INTO Desarrolladores (nombre, pais) VALUES
('Nintendo', 'Japón'),
('Sony Interactive Entertainment', 'Japón'),
('Microsoft Studios', 'Estados Unidos'),
('Ubisoft', 'Francia'),
('Rockstar Games', 'Estados Unidos'),
('CD Projekt Red', 'Polonia'),
('Electronic Arts', 'Estados Unidos'),
('Square Enix', 'Japón'),
('Capcom', 'Japón'),
('Valve', 'Estados Unidos');

INSERT INTO Plataformas (nombre) VALUES
('PC'),
('PlayStation 4'),
('PlayStation 5'),
('Xbox One'),
('Xbox Series X'),
('Nintendo Switch'),
('Stadia'),
('Steam Deck'),
('Mobile'),
('Meta Quest 2');

INSERT INTO Juegos (titulo, genero, lanzamiento, desarrollador_id, plataforma_id) VALUES
('The Legend of Zelda: Breath of the Wild', 'Aventura', '2017-03-03', 1, 6),
('God of War', 'Acción', '2018-04-20', 2, 2),
('Halo Infinite', 'FPS', '2021-12-08', 3, 5),
('Assassin\'s Creed Valhalla', 'Acción-RPG', '2020-11-10', 4, 4),
('Red Dead Redemption 2', 'Aventura', '2018-10-26', 5, 4),
('Cyberpunk 2077', 'RPG', '2020-12-10', 6, 2),
('FIFA 23', 'Deportes', '2022-09-30', 7, 3),
('Final Fantasy VII Remake', 'RPG', '2020-04-10', 8, 2),
('Resident Evil Village', 'Survival Horror', '2021-05-07', 9, 3),
('Half-Life: Alyx', 'VR Shooter', '2020-03-23', 10, 10),
('Super Mario Odyssey', 'Plataformas', '2017-10-27', 1, 6),
('Horizon Forbidden West', 'Acción-RPG', '2022-02-18', 2, 3),
('Gears 5', 'Acción', '2019-09-10', 3, 4),
('Far Cry 6', 'FPS', '2021-10-07', 4, 5),
('Grand Theft Auto V', 'Mundo Abierto', '2013-09-17', 5, 4),
('The Witcher 3: Wild Hunt', 'RPG', '2015-05-19', 6, 1),
('Battlefield 2042', 'FPS', '2021-11-19', 7, 3),
('Kingdom Hearts III', 'RPG', '2019-01-29', 8, 2),
('Monster Hunter: World', 'Acción-RPG', '2018-01-26', 9, 1),
('Portal 2', 'Puzles', '2011-04-18', 10, 1);

