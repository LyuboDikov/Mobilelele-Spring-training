INSERT INTO users (id, email, first_name, last_name, image_url, is_active, password)
VALUES (1, 'admin.adminov@gmail.com', 'Admin', 'Adminov', null, 1, '9feba29480881b5934cd11aff1057c1c81dc20aa905fdc6a3bac09d9c761fa71716e8d2e2a6298bd');


INSERT INTO brands (id, name)
VALUES (1, 'Ford'),
       (2, 'Toyota');


INSERT INTO models(id, name, category, start_year, end_year, brand_id, image_url)
VALUES (1, 'Fiesta', 'CAR', 1976, null, 1, 'https://carwow-uk-wp-1.imgix.net/2021_FORD_FIESTA_STUDIO_ST-LINE_04.jpg?auto=format&cs=tinysrgb&fit=crop&h=800&ixlib=rb-1.1.0&q=60&w=1600'),
       (2, 'Escort', 'CAR', 1968, 2000, 1, 'https://www.thesun.co.uk/wp-content/uploads/2023/05/d1793c33-e229-48fc-a302-26e758567184.jpg'),
       (3, 'Yaris', 'CAR', 1999, null, 2, 'https://scene7.toyota.eu/is/image/toyotaeurope/toyota-yaris-grs-2022-alternate-01?&wid=1280&fit=fit,1&ts=0&resMode=sharp2&op_usm=1.75,0.3,2,0');