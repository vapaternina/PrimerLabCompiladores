### Nota:
En la pestaña "Projects", están organizados los detalles del laboratorio.

# Instalación del repositorio

* En una consola, o gestor de repositorios, dirígete al directorio donde deseas clonar el repositorio
* Una vez en ese directorio usa:
```
git clone https://github.com/vapaternina/PrimerLabCompiladores.git
```
* Crea un branch para trabajar con: 
```
git branch nombre_branch
``` 
```
git checkout nombre_branch
```
o 
```
git checkout -b nombre_branch
```
## Otros:
### Actualizar tu repositorio local
* Si quieres actualizar a último commit (si clonaste el repositorio): 
```
git pull
```
### Subir commit a repositorio remoto (Github)
* Para subir commit, haz el commit en tu rama:
```
git commit -m "Detalles del commit"
```
Entonces, verifica que tienes en la rama **nombre_rama_donde_trabajaste** los últimos cambios (pull) y haz un push de la rama al repositorio remoto.
```
git pull
```
Agrega todos los cambios de archivos (si se agregaron o eliminaron nuevos archivos al repositorio),
```
git add -A
```
Por último, haz un push. Si es la primera vez que haces uno (verifica que hiciste lo anterior) usa:
```
git push -u nombre_rama_donde_trabajaste 
```
Si ya has usado ese comando para tu primer commit, puedes seguir usando:
```
git push origin nombre_rama_donde_trabajaste
```

Luego, desde GitHub haces un pull_request con los cambios en tu rama.

# COMPILADORES
## Primer Laboratorio
Construcción de Autómatas Finitos Determinísticos a través del método de Árbol Sintáctico y reconocimiento de cadenas.

### Tema: 
Autómatas Finitos
### Fecha de Inicio: 
Agosto 30 de 2.019
### Fecha de Entrega: 
Octubre 1 de 2.019
### Profesor: 
José Márquez Díaz
### Trabajo en equipo: 
2 personas
### Lenguaje: 
Java
## Planteamiento del Problema:
### Problema No. 1 (90%): 
Construcción de Autómatas Finitos Determinísticos.
### Entrada: 
Expresión Regular.
### Salidas: 
+ Señalar el Primerapos, Ultimapos de cada nodo del árbol en una tabla. (40%)
+ Siguientepos de cada posición (20%)
+ Alfabeto (5%)
+ Estados del AFD = Conjunto de posiciones (15%)
+ Autómata Finito Determinístico (Tabla TRAND) (10%)
### Método: 
Árbol Sintáctico

Se deben definir las funciones para + y ?.

### Problema No. 2 (10%): Reconocimiento de cadena.
Entrada: Cadena a reconocer
### Salidas: 
Si o No.
### Método: 
Recorrido de la cadena.

**Plus:** Si se dibuja el árbol y se señalan el Primerapos y Ultimapos se tendrá un punto (1.0)
adicional sobre la nota definitiva.

**Nota:** El símbolo Epsilon debe ser la &. Evite usar un símbolo para la concatenación dentro
de la expresión regular. Use solamente los símbolos para |,*, + y ? en las expresiones
regulares.

Cualquier retraso es cero punto cero (0.0) en el respectivo porcentaje.
Entrega hasta las 6:00 p.m. del día límite en un archivo comprimido con los nombres de los
integrantes conteniendo el programa fuente y el ejecutable. Este archivo debe ser colocado
en el link de trabajos de la página.

**Ejemplo:** El archivo se puede llamar Manuel Perez – John Garcia.zip
