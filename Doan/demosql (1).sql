-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 30, 2021 lúc 10:33 AM
-- Phiên bản máy phục vụ: 10.4.19-MariaDB
-- Phiên bản PHP: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `demosql`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `id` int(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `masv` varchar(50) NOT NULL,
  `link` varchar(100) NOT NULL,
  `DTB` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`id`, `name`, `masv`, `link`, `DTB`) VALUES
(10, 'nguyen trung hieu 2', 'pd0283', 'http://10.18.101.40/And1roid_Sever_MOB401/Anhthe/anhthe1.jpg', 9.7),
(11, 'Khanh Nam', 'PD01834', 'http://10.18.101.40/Android_Sever_MOB401/Anhthe/anhthe1.jpg', 8.5),
(12, 'Bui Vinh', 'PD018361', 'http://10.18.101.40/Android_Sever_MOB401/Anhthe/anhthe2.jpg', 8.2),
(13, 'Minh Nhat', 'PD01242', 'http://10.18.101.40/Android_Sever_MOB401/Anhthe/anhthe3.jpg', 7),
(14, 'Ngoc Hoi', 'PD019376', 'http://10.18.101.40/Android_Sever_MOB401/Anhthe/anhthe1.jpg', 8.3),
(15, 'Thi No', 'PD01382', 'http://10.18.101.40/Android_Sever_MOB401/Anhthe/anhthe4.jpg', 8.8),
(16, 'A Han', 'PD013834', 'http://10.18.101.40/Android_Sever_MOB401/Anhthe/anhthe5.jpg', 9.2),
(17, 'Trung Hieu 1', 'PD91424', 'http://10.18.101.40/Android_Sever_MOB401/Anhthe/anhthe1.jpg', 9.8),
(18, 'nguyen trung hieu 3', 'pd0283', 'http://10.18.101.40/And1roid_Sever_MOB401/Anhthe/anhthe1.jpg', 4),
(234, '5', '5', '5', 6),
(346, '56', '56', '56', 56),
(347, '14', '14', '14', 14);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lichhoc`
--

CREATE TABLE `lichhoc` (
  `thu` int(11) NOT NULL,
  `monhoc` varchar(100) NOT NULL,
  `giaovien` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `lichhoc`
--

INSERT INTO `lichhoc` (`thu`, `monhoc`, `giaovien`) VALUES
(2, 'Androi co ban t2', 'namnv'),
(3, 'android Nang Cao', 'namnv'),
(4, 'Tin hoc co so', 'namnv'),
(5, 'Unity 2D', 'namnv'),
(6, 'Tin hoc van phong', 'khanhnv'),
(7, 'Co so du lieu', 'dinhnv');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lop11305`
--

CREATE TABLE `lop11305` (
  `id` int(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `masv` varchar(50) NOT NULL,
  `link` varchar(100) NOT NULL,
  `DTB` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `lop11305`
--

INSERT INTO `lop11305` (`id`, `name`, `masv`, `link`, `DTB`) VALUES
(4, 'Huynh Bao Ty', 'Pd01813', 'http://10.18.101.40/Android_Sever_MOB401/Anhthe/anhthe1.jpg', 9),
(5, 'Huynh Bao Ty 01', 'PD1997', 'http://10.18.101.40/Android_Sever_MOB401/Anhthe/anhthe2.jpg', 8.5),
(6, 'Huynh Bao Ty 02', 'PD7991', 'http://10.18.101.40/Android_Sever_MOB401/Anhthe/anhthe2.jpg', 8.9),
(7, '1', '1', '1', 1),
(9, '34', '34', '34', 34),
(10, '1', '1', '1', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `monhoc`
--

CREATE TABLE `monhoc` (
  `id` int(50) NOT NULL,
  `tenmon` varchar(50) NOT NULL,
  `thuocnganh` varchar(50) NOT NULL,
  `linkpdf` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `monhoc`
--

INSERT INTO `monhoc` (`id`, `tenmon`, `thuocnganh`, `linkpdf`) VALUES
(1, 'Toán', 'Mobile1', ''),
(3, 'Vi?t', 'Mobile', ''),
(5, 'Tin hoc van phong', 'Mobile', 'https://drive.google.com/file/d/0BwJk9UVfV1Q2ZUJ1TXZjS2xGMms/view?usp=sharing'),
(6, 'Android co ban', 'Mobile', 'https://drive.google.com/file/d/0BwJk9UVfV1Q2aFlvMEVSRjU4bUE/view?usp=sharing'),
(7, 'Unity 2D ', 'Mobile', 'https://drive.google.com/file/d/0BwJk9UVfV1Q2RjVDZTJlWWpTUDA/view?usp=sharing'),
(8, 'Sever Android (php&nodejs)', 'Mobile', 'https://drive.google.com/file/d/0BwJk9UVfV1Q2czZ1YnZxOUxHbUk/view?usp=sharing');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `user_password` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`user_id`, `user_name`, `user_password`) VALUES
(1, 'hieu', '1234');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `lichhoc`
--
ALTER TABLE `lichhoc`
  ADD PRIMARY KEY (`thu`);

--
-- Chỉ mục cho bảng `lop11305`
--
ALTER TABLE `lop11305`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `monhoc`
--
ALTER TABLE `monhoc`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=348;

--
-- AUTO_INCREMENT cho bảng `lichhoc`
--
ALTER TABLE `lichhoc`
  MODIFY `thu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `lop11305`
--
ALTER TABLE `lop11305`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `monhoc`
--
ALTER TABLE `monhoc`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
