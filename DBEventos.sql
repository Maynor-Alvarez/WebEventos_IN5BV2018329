-- MySQL Workbench Forward Engineering

/*SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';*/

-- -----------------------------------------------------
-- Schema dbeventos
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dbeventos
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dbeventos` DEFAULT CHARACTER SET utf8 ;
USE `dbeventos` ;



-- -----------------------------------------------------
-- Table `dbeventos`.`tipoproducto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbeventos`.`tipoproducto` (
  `idtipoproducto` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idtipoproducto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbeventos`.`productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbeventos`.`productos` (
  `idproductos` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  `precioventa` DOUBLE NOT NULL,
  `fechavencimiento` DATE NOT NULL,
  `tipoproducto_idtipoproducto` INT NOT NULL,
  PRIMARY KEY (`idproductos`),
  INDEX `fk_productos_tipoproducto1_idx` (`tipoproducto_idtipoproducto` ASC),
  CONSTRAINT `fk_productos_tipoproducto1`
    FOREIGN KEY (`tipoproducto_idtipoproducto`)
    REFERENCES `dbeventos`.`tipoproducto` (`idtipoproducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbeventos`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbeventos`.`clientes` (
  `idclientes` INT NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `celular` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idclientes`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbeventos`.`evento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbeventos`.`evento` (
  `idevento` INT NOT NULL AUTO_INCREMENT,
  `tipoevento` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idevento`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbeventos`.`areas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbeventos`.`areas` (
  `idareas` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idareas`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbeventos`.`sucursal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbeventos`.`sucursal` (
  `idsucursal` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  `areas_idareas` INT NOT NULL,
  PRIMARY KEY (`idsucursal`),
  INDEX `fk_sucursal_areas1_idx` (`areas_idareas` ASC) ,
  CONSTRAINT `fk_sucursal_areas1`
    FOREIGN KEY (`areas_idareas`)
    REFERENCES `dbeventos`.`areas` (`idareas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbeventos`.`reservacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbeventos`.`reservacion` (
  `idreservacion` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(100) NOT NULL,
  `fechainicio` DATETIME NOT NULL,
  `fechafin` DATETIME NOT NULL,
  `idcliente` INT NOT NULL,
  `idevento` INT NOT NULL,
  `idsucursal` INT NOT NULL,
  `areas_idareas` INT NOT NULL,
  PRIMARY KEY (`idreservacion`),
  INDEX `FK_idreservacion_idclientes_idx` (`idcliente` ASC) ,
  INDEX `FK_idreservacion_idevento_idx` (`idevento` ASC) ,
  INDEX `FK_idreservacion_idlugarEvento_idx` (`idsucursal` ASC) ,
  INDEX `fk_reservacion_areas1_idx` (`areas_idareas` ASC) ,
  CONSTRAINT `FK_idreservacion_idclientes`
    FOREIGN KEY (`idcliente`)
    REFERENCES `dbeventos`.`clientes` (`idclientes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_idreservacion_idevento`
    FOREIGN KEY (`idevento`)
    REFERENCES `dbeventos`.`evento` (`idevento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_idreservacion_idsucursal`
    FOREIGN KEY (`idsucursal`)
    REFERENCES `dbeventos`.`sucursal` (`idsucursal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reservacion_areas1`
    FOREIGN KEY (`areas_idareas`)
    REFERENCES `dbeventos`.`areas` (`idareas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbeventos`.`detallecotizacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbeventos`.`detallecotizacion` (
  `iddetallecotizacion` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(100) NOT NULL,
  `productos_idproductos` INT NOT NULL,
  `precio` DOUBLE NOT NULL,
  `cantidad` INT NOT NULL,
  PRIMARY KEY (`iddetallecotizacion`),
  INDEX `fk_detalleCotizacion_productos1_idx` (`productos_idproductos` ASC) ,
  CONSTRAINT `fk_detalleCotizacion_productos1`
    FOREIGN KEY (`productos_idproductos`)
    REFERENCES `dbeventos`.`productos` (`idproductos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbeventos`.`cotizacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbeventos`.`cotizacion` (
  `idcotizacion` INT NOT NULL AUTO_INCREMENT,
  `reservacion_idreservacion` INT NOT NULL,
  `detallecotizacion_iddetallecotizacion` INT NOT NULL,
  PRIMARY KEY (`idcotizacion`),
  INDEX `fk_cotizacion_reservacion1_idx` (`reservacion_idreservacion` ASC) ,
  INDEX `fk_cotizacion_detallecotizacion1_idx` (`detallecotizacion_iddetallecotizacion` ASC) ,
  CONSTRAINT `fk_cotizacion_reservacion1`
    FOREIGN KEY (`reservacion_idreservacion`)
    REFERENCES `dbeventos`.`reservacion` (`idreservacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cotizacion_detallecotizacion1`
    FOREIGN KEY (`detallecotizacion_iddetallecotizacion`)
    REFERENCES `dbeventos`.`detallecotizacion` (`iddetallecotizacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbeventos`.`detallefactura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbeventos`.`detallefactura` (
  `iddetallefactura` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(100) NOT NULL,
  `productos_idproductos` INT NOT NULL,
  `precio` DOUBLE NOT NULL,
  `cantidad` INT NOT NULL,
  PRIMARY KEY (`iddetallefactura`),
  INDEX `fk_detalleFactura_productos1_idx` (`productos_idproductos` ASC) ,
  CONSTRAINT `fk_detalleFactura_productos1`
    FOREIGN KEY (`productos_idproductos`)
    REFERENCES `dbeventos`.`productos` (`idproductos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbeventos`.`facturacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbeventos`.`facturacion` (
  `idfacturacion` INT NOT NULL AUTO_INCREMENT,
  `cotizacion_idcotizacion` INT NOT NULL,
  `detallefactura_iddetallefactura` INT NOT NULL,
  PRIMARY KEY (`idfacturacion`),
  INDEX `fk_facturacion_cotizacion1_idx` (`cotizacion_idcotizacion` ASC) ,
  INDEX `fk_facturacion_detallefactura1_idx` (`detallefactura_iddetallefactura` ASC) ,
  CONSTRAINT `fk_facturacion_cotizacion1`
    FOREIGN KEY (`cotizacion_idcotizacion`)
    REFERENCES `dbeventos`.`cotizacion` (`idcotizacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_facturacion_detallefactura1`
    FOREIGN KEY (`detallefactura_iddetallefactura`)
    REFERENCES `dbeventos`.`detallefactura` (`iddetallefactura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;