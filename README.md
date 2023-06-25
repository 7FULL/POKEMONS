

## Lucha Pokémon

Este proyecto es un juego de lucha Pokémon desarrollado para ser ejecutado en una página web. Utiliza servlet en un servidor Tomcat para manejar la lógica del juego y ofrece diferentes modos de juego, incluyendo un solo jugador contra una IA y un modo multijugador utilizando la tecnología de WebSockets.

### Características

- Modo de un solo jugador: Permite a los jugadores luchar contra una inteligencia artificial controlada por el sistema.
- Modo multijugador: Permite a los jugadores conectarse y luchar contra otros jugadores en la misma red local.
- Tecnología de WebSockets: Utiliza WebSockets para establecer conexiones en tiempo real y permitir que los jugadores jueguen desde diferentes dispositivos en la red local.
- Sala de juegos: El modo multijugador admite la creación de hasta 3 salas simultáneas, lo que significa que pueden haber hasta 3 partidas en curso al mismo tiempo. Este límite de salas se puede parametrizar según tus necesidades.
- Fácil instalación: Proporciona instrucciones claras para la instalación y configuración del proyecto en un servidor Tomcat.

### Requisitos previos

Antes de comenzar, asegúrate de tener instalado lo siguiente:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Apache Tomcat](https://tomcat.apache.org/download-<TOMCAT_VERSION>.html) (versión compatible con Java 11)

### Instalación y configuración

1. Clona este repositorio en tu máquina local o descarga el archivo ZIP.
2. Descomprime el archivo ZIP si lo descargaste.
3. Abre el proyecto en tu IDE preferido.
4. Configura el servidor Tomcat en tu IDE y asegúrate de que esté correctamente vinculado al proyecto.
5. Compila y construye el proyecto.
6. Despliega el archivo WAR generado en tu servidor Tomcat.
7. Inicia el servidor Tomcat.

### Uso

Una vez que hayas configurado y ejecutado el proyecto en tu servidor Tomcat, puedes acceder al juego utilizando tu navegador web. Asegúrate de estar en la misma red local que otros jugadores si deseas jugar en modo multijugador.

- Modo de un solo jugador: En la página principal del juego, elige la opción para jugar contra la IA y sigue las instrucciones para comenzar la lucha Pokémon.
- Modo multijugador: En la página principal del juego, selecciona la opción de modo multijugador y únete a una de las salas disponibles. Luego, podrás desafiar a otros jugadores en tiempo real.



---


¡Diviértete jugando y luchando en el emocionante mundo Pokémon!


