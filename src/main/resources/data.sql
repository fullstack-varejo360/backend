INSERT INTO "users" ("name", "email", "password")
VALUES
    ('Rafael', 'rafael@email.com', '123456'),
    ('Eduardo', 'eduardo@email.com', '123456');

INSERT INTO "products" ("user_id", "code", "name")
VALUES
    ('1','123456789','Leite em pó'),
    ('2','987654321','Leite desnatado');