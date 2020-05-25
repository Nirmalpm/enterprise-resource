/*
-- Query: SELECT * FROM pachakari.unit
LIMIT 0, 1000

-- Date: 2020-05-25 10:07
*/
INSERT INTO enterprise (enterprise_id,enterprise_name) VALUES (1,'Grocery');
INSERT INTO enterprise (enterprise_id,enterprise_name) VALUES (2,'Accessories');
INSERT INTO enterprise (enterprise_id,enterprise_name) VALUES (3,'Apparels');
INSERT INTO enterprise (enterprise_id,enterprise_name) VALUES (4,'Home Appliances');

/*
-- Query: SELECT * FROM pachakari.unit
LIMIT 0, 1000

-- Date: 2020-05-25 10:07
*/
INSERT INTO unit (enterprise_id,unit_id,unit_name) VALUES (1,1,'Count');
INSERT INTO unit (enterprise_id,unit_id,unit_name) VALUES (1,2,'Grams');
INSERT INTO unit (enterprise_id,unit_id,unit_name) VALUES (1,3,'Kilo Grams');
INSERT INTO unit (enterprise_id,unit_id,unit_name) VALUES (1,4,'Bunch(es)');

/*
-- Query: SELECT * FROM pachakari.item
LIMIT 0, 1000

-- Date: 2020-05-25 10:07
*/
INSERT INTO item (enterprise_id,item_id,item_name,item_desc,item_price,item_quantity,item_unit,created_date,modified_date,image_name,created_user,modified_user) 
VALUES (1,1,'Coconut','Good for health',35,100,1,'2020-05-07 10:06:04','2020-05-22 21:27:16','coconut.jpg','NIRMALPM@GMAIL.COM','NIRMALPM@GMAIL.COM');

INSERT INTO item (enterprise_id,item_id,item_name,item_desc,item_price,item_quantity,item_unit,created_date,modified_date,image_name,created_user,modified_user) 
VALUES (1,2,'Mango','King of fruits',23,100,3,'2020-05-07 10:13:40','2020-05-22 21:27:34','mango.jpg','NIRMALPM@GMAIL.COM','NIRMALPM@GMAIL.COM');

INSERT INTO item (enterprise_id,item_id,item_name,item_desc,item_price,item_quantity,item_unit,created_date,modified_date,image_name,created_user,modified_user) 
VALUES (1,3,'Jack fruit','Kerala\'s national fruit',130,5,3,'2020-05-07 10:30:47','2020-05-22 21:27:53','chakka.jpg','NIRMALPM@GMAIL.COM','NIRMALPM@GMAIL.COM');

INSERT INTO item (enterprise_id,item_id,item_name,item_desc,item_price,item_quantity,item_unit,created_date,modified_date,image_name,created_user,modified_user) 
VALUES (1,4,'Moringa','One of the best vegetables with lots of nutrients',100,20,3,'2020-05-07 11:08:59','2020-05-22 21:30:21','moringa.jpg','NIRMALPM@GMAIL.COM','NIRMALPM@GMAIL.COM');

INSERT INTO item (enterprise_id,item_id,item_name,item_desc,item_price,item_quantity,item_unit,created_date,modified_date,image_name,created_user,modified_user) 
VALUES (1,5,'Orange','Oranges are good source of vitamin C',120,50,3,'2020-05-08 17:22:34','2020-05-22 21:30:34','orange.jpg','NIRMALPM@GMAIL.COM','NIRMALPM@GMAIL.COM');

INSERT INTO item (enterprise_id,item_id,item_name,item_desc,item_price,item_quantity,item_unit,created_date,modified_date,image_name,created_user,modified_user) 
VALUES (1,6,'Beet root','Best source of iron content',50,100,3,'2020-05-08 17:25:42','2020-05-22 21:30:50','beetroot.jpg','NIRMALPM@GMAIL.COM','NIRMALPM@GMAIL.COM');

INSERT INTO item (enterprise_id,item_id,item_name,item_desc,item_price,item_quantity,item_unit,created_date,modified_date,image_name,created_user,modified_user) 
VALUES (1,7,'Carrot','Best source of vitamin E',80,50,3,'2020-05-08 17:35:20','2020-05-22 21:32:46','carrot.jpg','NIRMALPM@GMAIL.COM','NIRMALPM@GMAIL.COM');

INSERT INTO item (enterprise_id,item_id,item_name,item_desc,item_price,item_quantity,item_unit,created_date,modified_date,image_name,created_user,modified_user) 
VALUES (1,8,'Snake gourd','Good vegetable',76,25,NULL,'2020-05-08 17:42:20',NULL,'snakegourd.jpg','NIRMALPM@GMAIL.COM',NULL);

INSERT INTO item (enterprise_id,item_id,item_name,item_desc,item_price,item_quantity,item_unit,created_date,modified_date,image_name,created_user,modified_user) 
VALUES (1,9,'Ridge gourd','Pottikka is the name of this in malayalam',80,25,3,'2020-05-08 17:50:57','2020-05-22 21:32:32','ridgegourd.jpg','NIRMALPM@GMAIL.COM','NIRMALPM@GMAIL.COM');

INSERT INTO item (enterprise_id,item_id,item_name,item_desc,item_price,item_quantity,item_unit,created_date,modified_date,image_name,created_user,modified_user) 
VALUES (1,10,'Bottle Gourd','Churanga in malayalam!',56,20,3,'2020-05-08 17:56:03','2020-05-22 21:32:11','bottlegourd.jpg','NIRMALPM@GMAIL.COM','NIRMALPM@GMAIL.COM');

INSERT INTO item (enterprise_id,item_id,item_name,item_desc,item_price,item_quantity,item_unit,created_date,modified_date,image_name,created_user,modified_user) 
VALUES (1,11,'Amaranthus','Cheera in Malayalam',35,15,NULL,'2020-05-08 18:06:08',NULL,'cheera.jpg','NIRMALPM@GMAIL.COM',NULL);

INSERT INTO item (enterprise_id,item_id,item_name,item_desc,item_price,item_quantity,item_unit,created_date,modified_date,image_name,created_user,modified_user) 
VALUES (1,12,'Palak','This is the most nutrient spinach',45,15,1,'2020-05-08 19:31:26','2020-05-22 21:33:54','palak.jpg','NIRMALPM@GMAIL.COM','NIRMALPM@GMAIL.COM');

INSERT INTO item (enterprise_id,item_id,item_name,item_desc,item_price,item_quantity,item_unit,created_date,modified_date,image_name,created_user,modified_user) 
VALUES (1,13,'Gobi','This is cauliflower',45,25,1,'2020-05-08 19:37:01','2020-05-22 21:31:57','gobi.jpg','NIRMALPM@GMAIL.COM','NIRMALPM@GMAIL.COM');

INSERT INTO item (enterprise_id,item_id,item_name,item_desc,item_price,item_quantity,item_unit,created_date,modified_date,image_name,created_user,modified_user) 
VALUES (1,14,'Mushroom','Rich in protein',45,10,3,'2020-05-08 19:38:26','2020-05-22 21:31:29','koonnu.jpg','NIRMALPM@GMAIL.COM','NIRMALPM@GMAIL.COM');

INSERT INTO item (enterprise_id,item_id,item_name,item_desc,item_price,item_quantity,item_unit,created_date,modified_date,image_name,created_user,modified_user) 
VALUES (1,15,'Cowpeas','The english name for this is cowpea',80,25,3,'2020-05-09 10:26:49','2020-05-22 21:29:34','payar.jpg','NIRMALPM@GMAIL.COM','NIRMALPM@GMAIL.COM');

INSERT INTO item (enterprise_id,item_id,item_name,item_desc,item_price,item_quantity,item_unit,created_date,modified_date,image_name,created_user,modified_user) 
VALUES (1,16,'Ladies Finger','This is called as Ladies Finger for what reason?',65,15,3,'2020-05-09 13:07:46','2020-05-22 21:25:59','vendakka.jpg','NIRMALPM@GMAIL.COM','NIRMALPM@GMAIL.COM');

INSERT INTO item (enterprise_id,item_id,item_name,item_desc,item_price,item_quantity,item_unit,created_date,modified_date,image_name,created_user,modified_user) 
VALUES (1,17,'Beans','Beans only',68,12,3,'2020-05-09 13:12:54','2020-05-22 21:28:25','beans.jpg','NIRMALPM@GMAIL.COM','NIRMALPM@GMAIL.COM');

INSERT INTO item (enterprise_id,item_id,item_name,item_desc,item_price,item_quantity,item_unit,created_date,modified_date,image_name,created_user,modified_user) 
VALUES (1,18,'Tapioca','Good for making crispy chips',20,15,3,'2020-05-09 13:15:39','2020-05-22 21:25:22','kizhangu.jpeg','NIRMALPM@GMAIL.COM','NIRMALPM@GMAIL.COM');

INSERT INTO item (enterprise_id,item_id,item_name,item_desc,item_price,item_quantity,item_unit,created_date,modified_date,image_name,created_user,modified_user) 
VALUES (1,19,'Sweet Potato','Tasty Sweet Potato',45,25,3,'2020-05-09 13:18:16','2020-05-22 21:24:44','madhurakizhangu.jpg','NIRMALPM@GMAIL.COM','NIRMALPM@GMAIL.COM');

INSERT INTO item (enterprise_id,item_id,item_name,item_desc,item_price,item_quantity,item_unit,created_date,modified_date,image_name,created_user,modified_user) 
VALUES (1,20,'Radish','Mullangi is Radish in english',46,15,3,'2020-05-09 14:38:47','2020-05-22 21:24:12','mullangi.jpg','NIRMALPM@GMAIL.COM','NIRMALPM@GMAIL.COM');

INSERT INTO item (enterprise_id,item_id,item_name,item_desc,item_price,item_quantity,item_unit,created_date,modified_date,image_name,created_user,modified_user) 
VALUES (1,21,'Lemon','Its Lemin Lemon!',5,50,1,'2020-05-09 14:41:36','2020-05-22 21:23:46','cherunaranga.jpg','NIRMALPM@GMAIL.COM','NIRMALPM@GMAIL.COM');

INSERT INTO item (enterprise_id,item_id,item_name,item_desc,item_price,item_quantity,item_unit,created_date,modified_date,image_name,created_user,modified_user) 
VALUES (1,22,'Tomato','Tomato is called Thakkali in malayalam',23,50,3,'2020-05-09 14:46:24','2020-05-22 21:21:33','tomato.jpg','NIRMALPM@GMAIL.COM','NIRMALPM@GMAIL.COM');

INSERT INTO item (enterprise_id,item_id,item_name,item_desc,item_price,item_quantity,item_unit,created_date,modified_date,image_name,created_user,modified_user) 
VALUES (1,23,'Brocolli','No idea about what it is called in malayalam',150,10,1,'2020-05-12 16:38:57',NULL,'brocolli.jpg','NIRMALPM@GMAIL.COM',NULL);

INSERT INTO item (enterprise_id,item_id,item_name,item_desc,item_price,item_quantity,item_unit,created_date,modified_date,image_name,created_user,modified_user) 
VALUES (1,24,'Ulli','This is called as Onion in english',23,100,3,'2020-05-13 12:47:05',NULL,'Ulli.jpg','NIRMALPM@GMAIL.COM',NULL);

INSERT INTO item (enterprise_id,item_id,item_name,item_desc,item_price,item_quantity,item_unit,created_date,modified_date,image_name,created_user,modified_user) 
VALUES (1,25,'Small Onion','This is small onion in english. In Kannada they call it Sambaar ulli',58,15,3,'2020-05-16 13:15:11','2020-05-22 21:21:03','cheriyulli.jpg','NIRMALPM@GMAIL.COM','NIRMALPM@GMAIL.COM');

INSERT INTO item (enterprise_id,item_id,item_name,item_desc,item_price,item_quantity,item_unit,created_date,modified_date,image_name,created_user,modified_user) 
VALUES (1,26,'Green Chilli','Chillies...',120,15,3,'2020-05-17 11:26:36','2020-05-22 21:20:47','mulaku.jpg','NIRMALPM@GMAIL.COM','NIRMALPM@GMAIL.COM');

INSERT INTO item (enterprise_id,item_id,item_name,item_desc,item_price,item_quantity,item_unit,created_date,modified_date,image_name,created_user,modified_user) 
VALUES (1,27,'Red Chilli','Red Chillies..',100,12,3,'2020-05-17 11:29:19','2020-05-22 21:19:10','red-chillies.jpg','NIRMALPM@GMAIL.COM','NIRMALPM@GMAIL.COM');

INSERT INTO item (enterprise_id,item_id,item_name,item_desc,item_price,item_quantity,item_unit,created_date,modified_date,image_name,created_user,modified_user) 
VALUES (1,28,'Rose Apple','This is called Rose apple or so...',45,12,3,'2020-05-17 11:49:21','2020-05-22 21:18:43','chaambakka.jpg','NIRMALPM@GMAIL.COM','NIRMALPM@GMAIL.COM');

INSERT INTO item (enterprise_id,item_id,item_name,item_desc,item_price,item_quantity,item_unit,created_date,modified_date,image_name,created_user,modified_user) 
VALUES (1,29,'Bitter Gourd','Pavakka or kaypakka is called as Bitter gourd in english',50,12,3,'2020-05-17 12:09:06','2020-05-22 21:18:21','pavakka.jpg','NIRMALPM@GMAIL.COM','NIRMALPM@GMAIL.COM');

INSERT INTO item (enterprise_id,item_id,item_name,item_desc,item_price,item_quantity,item_unit,created_date,modified_date,image_name,created_user,modified_user) 
VALUES (1,30,'Cabbage','Cabbage is cabbage',56,12,1,'2020-05-17 12:10:48','2020-05-19 13:57:45','cabbage.jpg','NIRMALPM@GMAIL.COM',NULL);

INSERT INTO item (enterprise_id,item_id,item_name,item_desc,item_price,item_quantity,item_unit,created_date,modified_date,image_name,created_user,modified_user) 
VALUES (1,31,'Purple Cabbage','Purple Cabbage is Purple Cabbage',30,12,1,'2020-05-17 12:26:56','2020-05-18 13:58:43','cabbage-purple.jpg','NIRMALPM@GMAIL.COM',NULL);

INSERT INTO item (enterprise_id,item_id,item_name,item_desc,item_price,item_quantity,item_unit,created_date,modified_date,image_name,created_user,modified_user) 
VALUES (1,32,'Brinjal','Vazhuthininga in malayalam',23,15,3,'2020-05-17 13:29:23','2020-05-18 13:57:56','brinjal.jpg','NIRMALPM@GMAIL.COM',NULL);

INSERT INTO item (enterprise_id,item_id,item_name,item_desc,item_price,item_quantity,item_unit,created_date,modified_date,image_name,created_user,modified_user) 
VALUES (1,33,'Goose Berry1','Nellikka in malayalam',2,23,1,'2020-05-17 13:31:36','2020-05-20 14:24:11','nellikka.jpg','NIRMALPM@GMAIL.COM',NULL);

INSERT INTO item (enterprise_id,item_id,item_name,item_desc,item_price,item_quantity,item_unit,created_date,modified_date,image_name,created_user,modified_user) 
VALUES (1,34,'Ginger','Ginger is an awesome home remedy for cough',100,1,3,'2020-05-20 16:31:44','2020-05-22 21:17:39','inji.jpg','nirmalpm3@gmail.com','NIRMALPM@GMAIL.COM');

