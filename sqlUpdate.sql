CREATE DATABASE databaseSpringFood;

use databaseSpringFood;


-- Cấu trúc bảng cho bảng `book_party`
CREATE TABLE `book_party` (
  `id_party` int(11) NOT NULL AUTO_INCREMENT,
  `date_order` date NOT NULL,
  `time_order` varchar(50) NOT NULL,
  `quantity` int(11) NOT NULL,
  `address` varchar(250) NOT NULL,
  `content` varchar(250) NOT NULL,
  `id_customer` int(11) NOT NULL,
  PRIMARY KEY (`id_party`),
  KEY `id_customer` (`id_customer`),
  CONSTRAINT `book_party_ibfk_1` FOREIGN KEY (`id_customer`) REFERENCES `customer` (`id_customer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

delete from `book_party` where id_party = 4;
ALTER TABLE `book_party` MODIFY time_order TIME NULL;


-- Cấu trúc bảng cho bảng `categories`
CREATE TABLE `categories` (
  `id_categories` int(11) NOT NULL AUTO_INCREMENT,
  `name_categories` varchar(100) NOT NULL,
  `image_categories` varchar(100) NOT NULL,
  PRIMARY KEY (`id_categories`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE `categories`
MODIFY COLUMN `image_categories` varchar(255) NOT NULL;


-- Cấu trúc bảng cho bảng `customer`
CREATE TABLE `customer` (
  `id_customer` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  `phonenumber` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `gender` varchar(20) NOT NULL,
  `date` date NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`id_customer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE databasespringfood.customer
ADD COLUMN role ENUM('USER', 'ADMIN') NOT NULL DEFAULT 'USER';


-- Cấu trúc bảng cho bảng `food`
CREATE TABLE `food` (
  `ID_food` int(11) NOT NULL AUTO_INCREMENT,
  `name_food` varchar(100) NOT NULL,
  `image_food` varchar(100) NOT NULL,
  `price` int(11) NOT NULL,
  `id_categories` int(11) NOT NULL,
  PRIMARY KEY (`ID_food`),
  KEY `id_categories` (`id_categories`),
  CONSTRAINT `food_ibfk_1` FOREIGN KEY (`id_categories`) REFERENCES `categories` (`id_categories`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Cấu trúc bảng cho bảng `cart`
CREATE TABLE `cart` (
  `id_cart` int(11) NOT NULL AUTO_INCREMENT,
  `ID_food` int(11) NOT NULL,
  `id_customer` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`id_cart`),
  KEY `id_customer` (`id_customer`),
  KEY `ID_food` (`ID_food`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`ID_food`) REFERENCES `food` (`ID_food`),
  CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`id_customer`) REFERENCES `customer` (`id_customer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE databasespringfood.cart
ADD COLUMN status INT DEFAULT 0;

delete from `cart` where id_cart = 11;


-- Cấu trúc bảng cho bảng `payment`
CREATE TABLE `payment` (
  `id_payment` int(11) NOT NULL AUTO_INCREMENT,
  `name_food` varchar(100) NOT NULL,
  `price` float NOT NULL,
  `total` float NOT NULL,
  `quantity` int(11) NOT NULL,
  `fullName` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `id_customer` int(11) NOT NULL,
  PRIMARY KEY (`id_payment`),
  KEY `id_customer` (`id_customer`),
  CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`id_customer`) REFERENCES `customer` (`id_customer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Thêm cột `id_cart` vào bảng `payment`
ALTER TABLE `payment`
ADD COLUMN `id_cart` INT NOT NULL;

ALTER TABLE `payment`
DROP FOREIGN KEY `payment_ibfk_1`;

-- Xóa cột `id_customer` nếu không cần thiết
ALTER TABLE `payment`
DROP COLUMN `id_customer`;

-- Thêm ràng buộc khóa ngoại giữa `id_cart` và `id_cart` trong bảng `cart`
ALTER TABLE `payment`
ADD CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`id_cart`) REFERENCES `cart` (`id_cart`);

ALTER TABLE `payment`
DROP COLUMN `full_Name`;

ALTER TABLE `payment`
DROP COLUMN `fullName`;

ALTER TABLE `payment`
DROP COLUMN `email`;

ALTER TABLE `payment`
ADD COLUMN `time` DATETIME DEFAULT CURRENT_TIMESTAMP;

-- Thêm cột `status_pay` với kiểu dữ liệu `INT` và giá trị mặc định là 0
ALTER TABLE `payment`
ADD COLUMN `status_pay` INT NOT NULL DEFAULT 0;

-- Cấu trúc bảng cho bảng `poster`
CREATE TABLE `poster` (
  `id_image` int(11) NOT NULL AUTO_INCREMENT,
  `name_image` varchar(250) NOT NULL,
  `image` varchar(255) NOT NULL,
  PRIMARY KEY (`id_image`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Cấu trúc bảng cho bảng `poster`
CREATE TABLE `token` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `token` varchar(250) NOT NULL,
  `token_type` varchar(255) NOT NULL,
  `expired` varchar(250) NOT NULL,
  `revoked` varchar(255) NOT NULL,
  `id_customer` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_customer` (`id_customer`),
  CONSTRAINT `token_ibfk_1` FOREIGN KEY (`id_customer`) REFERENCES `customer` (`id_customer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



-- Đang đổ dữ liệu cho bảng `book_party`
-- INSERT INTO `book_party` (`id_party`, `fullname`, `phone`, `email`, `date`, `time`, `quantity`, `address`, `content`) VALUES
-- (1, 'aBC', 1234567890, 'huy@gmail.com', '2024-01-12', '17:30', 10, 'Lotte mart Đà Nẵng', 'abcdef');

-- Đang đổ dữ liệu cho bảng `categories`
INSERT INTO `categories` (`id_categories`, `name_categories`, `image_categories`) VALUES
(1, 'HOT DEALS', 'KHUYEN_MAI.jpg'),
(2, 'NEW FOOD', 'MON_MOI.jpg'),
(3, 'SNACK', 'snack.jpg'),
(4, 'DESSERT & DRINKS', 'TRANG_MIENG.jpg'),
(5, 'RICE', 'COM.jpg'),
(6, 'CHICKEN', 'GA.jpg');

-- Đang đổ dữ liệu cho bảng `customer`
INSERT INTO `customer` (`id_customer`, `firstname`, `lastname`, `phonenumber`, `email`, `gender`, `date`, `password`) VALUES
(1, 'quang', 'huy', 1923456876, 'huy@gmail.com', 'male', '2003-01-01', '123456789');

-- Đang đổ dữ liệu cho bảng `food`
INSERT INTO `food` (`ID_food`, `name_food`, `image_food`, `price`, `id_categories`) VALUES
(1, 'Combo Happy Family', 'happy_family_social.jpg', 155000, 1),
(2, 'Combo Happy Family', 'happy_family.jpg', 125000, 1),
(3, 'Combo happy meal', 'happy_meal_social.jpg', 65000, 1),
(4, 'Combo happy meal', 'happy_meal.jpg', 50000, 1),
(5, '1 Sassy Chicken', '1-ga-cuon-dia-trung-hai.jpg', 41000, 2),
(6, '2 Sassy Chicken', '2-ga-cuon-dia-trung-hai.jpg', 79000, 2),
(7, '3 Sassy Chicken', '3-ga-cuon-dia-trung-hai.jpg', 117000, 2),
(8, 'Combo Sassy Chicken A', 'A-Cajun.jpg', 92000, 2),
(9, 'Combo Sassy Chicken B', 'B-Cajun.jpg', 120000, 2),
(10, 'Combo Cajun Chicken Popsicles A', 'combo-ga-cuon-dia-trung-hai-a.jpg', 91000, 2),
(11, 'Combo Cajun Chicken Popsicles B', 'combo-ga-cuon-dia-trung-hai-b.jpg', 89000, 2),
(12, 'Combo Cajun Chicken Popsicles C', 'combo-ga-cuon-dia-trung-hai-c.jpg', 100000, 2),
(13, '1 CAJUN CHICKEN POPSICLES', '1-Cajun.jpg', 40000, 2),
(14, '1 BEIJING WRAPS', '1-ga-cuon-bac-kinh.jpg', 39000, 2),
(15, '2 BEIJING WRAPS', '2-ga-cuon-bac-kinh.jpg', 74000, 2),
(16, 'BEIJING WRAPS HD', 'combo-ga-cuon-bac-kinh.jpg', 89000, 2),
(17, '2 SKEWERS', '2-Skewers.jpg', 40000, 3),
(18, '3 FISHSTICKS', '3-Fishsticks.jpg', 40000, 3),
(19, '4 CHEWY CHEESE', '4-Chewy-Cheese.jpg', 34000, 3),
(20, '6 Chewy Cheese', '6-Chewy-Cheese.jpg', 44000, 3),
(21, 'Seaweed Soup', 'Soup-Rong-Bien.jpg', 17000, 3),
(22, '3 Nuggests', '3_Nuggests.jpg', 15000, 4),
(23, '3 Nuggests', '5_Nuggests.jpg', 25000, 4),
(24, '1 Lipton Lemon Tea Large', 'Lipton.jpg', 17000, 4),
(25, 'Pepsi Can', 'Pepsi-Can.jpg', 17000, 4),
(26, '7 Up Can', '7Up-Can.jpg', 17000, 4),
(27, 'Aquafina 500ml', 'Aquafina-500ml.jpg', 15000, 4),
(28, 'Pepsi Zero Can', 'pepsi-zero.jpg', 17000, 4),
(29, 'Milo Box', 'milo-box-hd.jpg', 20000, 4),
(30, 'Peach Tea', 'Peach-Tea.jpg', 24000, 4),
(31, 'Skewer Rice', 'Rice-Skewer.jpg', 45000, 5),
(32, 'Zinger Chicken Pasta', 'MY-Y-ZINGER.jpg', 58000, 5),
(33, 'Tenderods Rice', 'Rice-TENDERODS.jpg', 45000, 5),
(34, 'Teriyaki Rice', 'Rice-Teriyaki.jpg', 45000, 5),
(35, 'Popcorn Pasta', 'MY-Y-POP.jpg', 40000, 5),
(36, 'Burger Flava', 'Burger-Flava.jpg', 40000, 5),
(37, 'Burger Shrimp', 'Burger-Shrimp.jpg', 44000, 5),
(38, '1 Fried Chicken', '1-Fried-Chicken.jpg', 35000, 6),
(39, '2 Fried Chicken', '2-Fried-Chicken.jpg', 70000, 6),
(40, '3 Fried Chicken', '3-Fried-Chicken.jpg', 103000, 6),
(41, '6 Fried Chicken', 'GA.jpg', 201000, 6),
(42, '1 ROASTED FILLET', 'MOD-PHI-LE-GA-QUAY.jpg', 38000, 6);

-- Đang đổ dữ liệu cho bảng `payment`
INSERT INTO `payment` (`id_payment`, `name_food`, `price`, `total`, `quantity`, `fullName`, `email`, `address`, `id_customer`) VALUES
(1, '1 Sassy Chicken, 1 CAJUN CHICKEN POPSICLES, Pepsi Zero Can', 17000, 139000, 4, 'Quang Huy', 'huy@gmail.com', 'vku university - Da Nang City', 1);

-- Đang đổ dữ liệu cho bảng `poster`
INSERT INTO `poster` (`id_image`, `name_image`, `image`) VALUES
(1, 'poster delivery', 'delivery.png'),
(2, 'poster giam gia', 'R.png'),
(3, 'poster mon an', 'poster1.jpeg');
