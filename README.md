# API para enviar correos electronicos con Spring Boot
Esta API permite enviar correos electrónicos a multiples personas utilizando Spring Boot. Proporciona un endpoint para enviar emails con archivos y otro para enviar emails
sin archivos.


1. [Herramientas](#herramientas)
2. [Dependencias](#dependencias)
3. [Configuración](#configuración)
   - [Propiedades](#properties)
   - [Obtener contraseña de aplicación](#obtener-contraseña-de-aplicación)
4. [Uso en Postman](#uso-en-postman)
   - [Enviar correo sin archivos](#sin-archivos)
   - [Enviar correo con archivos](#con-archivos)
5. [Clonar repositorio](#clonar-repositorio)




## Herramientas
- Java 17 
- Spring Boot 3
- Maven
- Cuenta de Gmail

## Dependencias
  ```xml
<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-mail</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

```
## Configuración

### Properties
 ```
email.sender.username=ejemplo@gmail.com
email.sender.password=jdiednrbeidjhxx

spring.servlet.multipart.enabled=true
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB
```
-  ``` email.sender.username= ``` direccion de gmail del remitente
- ``` email.sender.password= ``` contraseña de aplicacion
- ``` spring.servlet.multipart.enabled= ``` habilita el soporte para solicitudes multipart. Esto es necesario para manejar la carga de archivos
- ``` spring.servlet.multipart.max-file-size= ```  establece el tamaño máximo permitido para un archivo
- ``` spring.servlet.multipart.max-request-size= ``` define el tamaño máximo permitido para una solicitud multipart completa
> ⚠️ **IMPORTANTE:** La contraseña de aplicacion no es la misma que la de tu cuenta de Google



### Obtener contraseña de aplicación
1. Ve a tu cuenta de <a href="https://myaccount.google.com/?utm_source=account-marketing-page&utm_medium=go-to-account-button&pli=1&nlr=1" target="_blank">Google</a>
2. En la sección de "Seguridad" o en el buscador, busca "Contraseñas de aplicaciones"
3. Haz clic en "Contraseñas de aplicaciones"
4. Ponle un nombre a la aplicacion y haz clic en "Crear"
5. Copia la contraseña de 16 caracteres y pegala en  ``` email.sender.password  ```

## Uso en Postman
### Sin archivos
- Utilizaremos la siguiente URL para enviar un mail sin archivos
  
``` URL
http://localhost:8080/apiEmail/send
```
![image](https://github.com/user-attachments/assets/d9c44e34-6ced-4c3b-92d6-4dbb85c7ea4c)
- **toUser:** destinatarios
- **subject:** titulo del mensaje
- **message:** cuerpo del mensaje

### Con archivos
- Utilizaremos la siguiente URL para enviar un mail con archivos

  ``` URL
   http://localhost:8080/apiEmail/sendFile
  ```
![image](https://github.com/user-attachments/assets/d865a6e1-fb7b-4fdb-b1d0-2b837ca0c48d)
- **toUser:** destinatarios
- **subject:** titulo del mensaje
- **message:** cuerpo del mensaje
- **file:** archivo

## Clonar repositorio
```bash
   git clone https://github.com/franlugea/MailSender.git

