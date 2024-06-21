create database dbregistarvendas;
use dbregistarvendas;
create table vendas(
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Cliente VARCHAR(255) NOT NULL,
    Veiculo VARCHAR(255) NOT NULL,
    Modelo VARCHAR(50) NOT NULL,
    Cor VARCHAR(50),
    Preco DOUBLE NOT NULL,
    AnoFabrico Double
);


