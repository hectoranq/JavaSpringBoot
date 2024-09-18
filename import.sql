insert into usuarios (username,password,enabled,nombre,apellido,email) values('carlos','12345',1,'Carlos','Carreño','carlos@cognos.com');
insert into usuarios (username,password,enabled,nombre,apellido,email) values('franklin','12345',1,'Franklin','Noloc','franklin@cognos.com');

insert into roles (nombre) values('ROLE_USER');
insert into roles (nombre) values('ROLE_ADMIN');

insert into usuarios_roles (usuario_id, role_id) values (1,1);
insert into usuarios_roles (usuario_id, role_id) values (2,2);
insert into usuarios_roles (usuario_id, role_id) values (2,1);
