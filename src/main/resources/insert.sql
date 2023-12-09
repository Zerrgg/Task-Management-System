-- Добавление ролей
INSERT INTO roles (role_id, name) VALUES
(1, 'Admin'),
(2, 'User'),
(3, 'Guest');

-- Добавление прав доступа
INSERT INTO permissions (permission_id, name) VALUES
(1, 'Read'),
(2, 'Write'),
(3, 'Delete'),
(4, 'Manage Users'),
(5, 'Manage Roles');

-- Связывание ролей с правами доступа
INSERT INTO role_permissions (role_id, permission_id) VALUES
(1, 4), -- Admin имеет право на управление пользователями
(1, 5), -- Admin имеет право на управление ролями
(2, 1), -- User имеет право на чтение
(2, 2), -- User имеет право на запись
(2, 3), -- User имеет право на удаление
(3, 1); -- Guest имеет право на чтение