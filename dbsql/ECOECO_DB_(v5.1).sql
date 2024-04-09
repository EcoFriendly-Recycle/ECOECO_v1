SET sql_mode = '';

drop database ecoeco;
create database ecoeco;
grant all privileges on ecoeco.* to 'ohgiraffers'@'%';
show grants for 'ohgiraffers'@'%';
use ecoeco;


DROP TABLE `USER_INFO`;
DROP TABLE `NOTICE`;
DROP TABLE `NOTICE_IMAGE`;
DROP TABLE `PAYMENT`;
DROP TABLE `SETTLEMENT`;
DROP TABLE `REFUND`;
DROP TABLE `ORDER`;
DROP TABLE `PROJECT`;
DROP TABLE `MAKER`;
DROP TABLE `NEWS`;
DROP TABLE `STORY`;
DROP TABLE `CATEGORY`;
DROP TABLE `REWARD`;
DROP TABLE `SUPPORT_REVIEWS`;
DROP TABLE `US_GREEN`;
DROP TABLE `US_GREEN_GOOD`;
DROP TABLE `US_GREEN_IMAGE`;
DROP TABLE `US_GREEN_COMMENT`;
DROP TABLE `US_GREEN_COMMENT_GOOD`;


CREATE TABLE `USER_INFO` (
					`userNo` INT NOT NULL AUTO_INCREMENT COMMENT '회원번호',
                    `userId` VARCHAR(20) NOT NULL COMMENT '회원아이디',
                    `userPwd` VARCHAR(20) NOT NULL COMMENT '비밀번호',
                    `userName` VARCHAR(5) NOT NULL COMMENT '회원명',
                    `userPnum` VARCHAR(15) COMMENT '전화번호',
                    `userEmail` VARCHAR(255) NOT NULL COMMENT '이메일',
                    `userBirth` INT COMMENT '생년월일',
                    `userGender` CHAR(1) COMMENT '성별',
                    `userGrade` INT COMMENT '등급',
                    `userPoint` INT COMMENT '포인트',
                    `userDate` DATE NOT NULL COMMENT '가입일',
                    `userAccount` INT COMMENT '계좌번호',
                    `userAddress` VARCHAR(255) COMMENT '주소',
                    `managerYN` CHAR(1) DEFAULT 'N' COMMENT '관리자 권한 여부',
                    PRIMARY KEY(`userNo`)
    ) COMMENT = '회원정보';


CREATE TABLE `NOTICE` (
					 `noticeNo` INT NOT NULL AUTO_INCREMENT COMMENT '공지사항 번호',
                     `noticeCategory` VARCHAR(5) NOT NULL COMMENT '공지사항 분류',
                     `noticeSubCategory` VARCHAR(10) COMMENT '공지사항 소분류',
                     `noticeTitle` VARCHAR(255) NOT NULL COMMENT '공지사항 제목',
                     `noticeDetail` VARCHAR(150) NOT NULL COMMENT '공지사항 내용',
                     `noticeDate` DATE NOT NULL COMMENT '작성날짜',
					 `userNo` INT NOT NULL COMMENT '회원번호',
                     PRIMARY KEY(`noticeNo`)
	) COMMENT = '공지사항';


CREATE TABLE `NOTICE_IMAGE` (
							`noticeImgNo` INT AUTO_INCREMENT COMMENT '공지 이미지번호',
                            `noticeOriginFileName` VARCHAR(255) NOT NULL COMMENT '공지 이미지 원본명',
                            `noticeSaveName` VARCHAR(255) NOT NULL COMMENT '공지 이미지 저장명',
                            `noticePath` VARCHAR(255) NOT NULL COMMENT '공지 이미지 경로명',
                            `noticeNo` INT NOT NULL COMMENT '공지사항 번호',
                            PRIMARY KEY(`noticeImgNo`)
	) COMMENT = '공지사항 이미지';
    
    
CREATE TABLE `ORDER` (
							`orderNo` INT NOT NULL AUTO_INCREMENT COMMENT '주문번호',
                            `orderPrice` INT COMMENT '주문금액',
                            `orderStatus` VARCHAR(255) NOT NULL COMMENT '주문상태',
                            `paymentCategory` VARCHAR(255) COMMENT '결제분류',
                            `paymentStatus` VARCHAR(255) COMMENT '결제상태',
                            `orderDate` DATE NOT NULL COMMENT '주문일시',
                            `recipient`  VARCHAR(15) COMMENT '수령인',
                            `orderPhone` VARCHAR(5) COMMENT '연락처',
                            `orderAdd` VARCHAR(255) COMMENT '배송지',
                            PRIMARY KEY(`orderNo`)
	) COMMENT = '주문';
    
CREATE TABLE `PAYMENT` (
							`paymentNo` INT NOT NULL AUTO_INCREMENT COMMENT '결제 번호',
                            `paymentPrice` INT NOT NULL COMMENT '결제 금액',
                            `paymentDate` DATE NOT NULL COMMENT '결제일시',
                            `apiPayNo`  VARCHAR(255) COMMENT 'api결제번호',
                            PRIMARY KEY(`paymentNo`)
	) COMMENT = '결제';
    
    
    CREATE TABLE `SETTLEMENT` (
							`settlementNo` INT NOT NULL AUTO_INCREMENT COMMENT '정산번호',
                            `settlementStatus` VARCHAR(1) NOT NULL COMMENT '정산상태',
                            `settlementPrice` BIGINT NOT NULL COMMENT '정산금액',
                            `settlementDate` DATE NOT NULL COMMENT '정산일자',
                            PRIMARY KEY(`settlementNo`)
	) COMMENT = '정산';
    
    
CREATE TABLE `REFUND` (
							`refundNo` INT NOT NULL AUTO_INCREMENT COMMENT '환불번호',
                            `accountnum` INT NOT NULL COMMENT '계좌번호',
                            `refundRequestDate` DATE NOT NULL COMMENT '환불요청일',
                            `refundDate` DATE COMMENT '환불완료일',
                            `refundStatus`  VARCHAR(6) COMMENT '환불상태',
                            PRIMARY KEY(`refundNo`)
	) COMMENT = '환불';
    
    

                            
    


CREATE TABLE `PROJECT` (
						`projectNo`    INTEGER NOT NULL AUTO_INCREMENT COMMENT '프로젝트 번호',
						`projectName`    VARCHAR(255) NOT NULL COMMENT '프로젝트명',
						`projectSorN`    CHAR(1) COMMENT '성공여부',
						`deliveryYN`    CHAR(1) NOT NULL COMMENT '배송여부',
						`serviceCharge`    TINYINT(2) NOT NULL COMMENT '서비스요금(수수료)',
						`targetAmount`    INTEGER NOT NULL COMMENT '목표금액',
						`requestDate`    DATE COMMENT '요청일',
						`approvalDate`    DATE COMMENT '승인일',
						`petitionDate`    DATE COMMENT '반려일',
						`startDate`    DATE NOT NULL COMMENT '시작일',
						`endDate`    DATE NOT NULL COMMENT '종료일',
						`achievedAmount`    BIGINT(12) COMMENT '달성액',
						`dueDate`    DATE COMMENT '마감일',
						`thumbnail`    VARCHAR(100) COMMENT '썸네일',
						`categoryCode`    TINYINT(2) NOT NULL COMMENT '카테고리번호',
						PRIMARY KEY ( `projectNo` )
	) COMMENT = '프로젝트';



CREATE TABLE `MAKER`
(
    `makerNo`    INTEGER NOT NULL AUTO_INCREMENT COMMENT '메이커번호',
    `makerName`    VARCHAR(10) NOT NULL COMMENT '메이커명',
    `prImage`    VARCHAR(100) NOT NULL COMMENT '메이커프로필',
    `email`    VARCHAR(30) NOT NULL COMMENT '이메일',
    `phone`    VARCHAR(15) NOT NULL COMMENT '전화번호',
    `userNo`    INTEGER NOT NULL COMMENT '회원번호',
    `projectNo`    INTEGER NOT NULL COMMENT '프로젝트 번호',
 PRIMARY KEY ( `makerNo` )
) COMMENT = '메이커정보';



CREATE TABLE `NEWS`
(
    `newsNo`    INTEGER NOT NULL AUTO_INCREMENT COMMENT '새소식 번호',
    `newsCategory`    VARCHAR(10) NOT NULL COMMENT '새소식 분류',
    `newsTitle`    VARCHAR(20) NOT NULL COMMENT '새소식 제목',
    `newsContent`    VARCHAR(150) NOT NULL COMMENT '새소식 내용',
    `newsDate`    DATE DEFAULT '0000-00-00' NOT NULL COMMENT '새소식 작성날짜',
    `newsImage`    VARCHAR(100) COMMENT '새소식 이미지',
    `projectNo`    INTEGER COMMENT '프로젝트 번호',
    `userNo`    INTEGER COMMENT '회원번호',
 PRIMARY KEY ( `newsNo` )
) COMMENT = '새소식';



CREATE TABLE `STORY`
(
    `storyNo`    INTEGER NOT NULL AUTO_INCREMENT COMMENT '스토리번호',
    `storySummary`    VARCHAR(100) NOT NULL COMMENT '요약',
    `storyImg`    VARCHAR(100) NOT NULL COMMENT '대표이미지',
    `storyInfo`    VARCHAR(500) NOT NULL COMMENT '스토리내용',
    `projectNo`    INTEGER NOT NULL COMMENT '프로젝트 번호',
 PRIMARY KEY ( `storyNo` )
) COMMENT = '스토리';



CREATE TABLE `CATEGORY`
(
    `categoryCode`    TINYINT(2) NOT NULL AUTO_INCREMENT
 COMMENT '카테고리번호',
    `categoryName`    VARCHAR(20) NOT NULL COMMENT '카테고리명',
 PRIMARY KEY ( `categoryCode` )
) COMMENT = '카테고리';



CREATE TABLE `REWARD`
(
    `rewardNo`    INTEGER NOT NULL AUTO_INCREMENT COMMENT '리워드번호',
    `rewardName`    VARCHAR(255) NOT NULL COMMENT '리워드명',
    `rewardSum`    INTEGER NOT NULL COMMENT '금액',
    `rewardInfo`    VARCHAR(255) NOT NULL COMMENT '리워드설명',
    `projectNo`    INTEGER NOT NULL COMMENT '프로젝트 번호',
 PRIMARY KEY ( `rewardNo` )
) COMMENT = '리워드';



CREATE TABLE `SUPPORT_REVIEWS`
(
    `supportReviewsNo`    INTEGER NOT NULL AUTO_INCREMENT COMMENT '응원리뷰번호',
    `supportReviewsDate`    DATE DEFAULT '0000-00-00' NOT NULL COMMENT '작성날짜',
    `supportReviewsContent`    VARCHAR(150) NOT NULL COMMENT '응원리뷰내용',
    `supportReviewsCategory`    INTEGER NOT NULL COMMENT '응원리뷰분류',
    `projectNo`    INTEGER COMMENT '프로젝트 번호',
    `userNo`    INTEGER COMMENT '회원번호',
 PRIMARY KEY ( `supportReviewsNo` )
) COMMENT = '응원/리뷰';



CREATE TABLE `US_GREEN`
(
    `comuNo`    INTEGER NOT NULL AUTO_INCREMENT COMMENT '커뮤니티번호',
    `comuTitle`    VARCHAR(255) NOT NULL COMMENT '커뮤니티제목',
    `comuDetail`    VARCHAR(300) NOT NULL COMMENT '커뮤니티내용',
    `comuDate`    DATE DEFAULT '0000-00-00' NOT NULL COMMENT '커뮤니티작성일',
    `comuDelete`    CHAR(1) DEFAULT 'N' NOT NULL COMMENT '삭제여부',
    `userNo`    INTEGER NOT NULL COMMENT '회원번호',
 PRIMARY KEY ( `comuNo` )
) COMMENT = '우리가그린(커뮤니티)';



CREATE TABLE `US_GREEN_GOOD`
(
    `likeNo`    INTEGER NOT NULL AUTO_INCREMENT COMMENT '번호',
    `likeCount`    INTEGER COMMENT '좋아요',
    `badCount`    INTEGER COMMENT '아쉬워요',
    `userNo`    INTEGER NOT NULL COMMENT '회원번호',
    `comuNo`    INTEGER NOT NULL COMMENT '커뮤니티번호',
 PRIMARY KEY ( `likeNo` )
) COMMENT = '우리가그린(커뮤니티) 좋아요';



CREATE TABLE `US_GREEN_IMAGE`
(
    `comuImgNo`    INTEGER NOT NULL AUTO_INCREMENT COMMENT '커뮤니티 이미지번호',
    `comuOriginFileName`    VARCHAR(255) NOT NULL COMMENT '커뮤니티 이미지 원본명',
    `comuSaveName`    VARCHAR(255) NOT NULL COMMENT '커뮤니티 이미지 저장명',
    `comuPath`    VARCHAR(255) NOT NULL COMMENT '커뮤니티 이미지 경로명',
    `comuNo`    INTEGER NOT NULL COMMENT '커뮤니티번호',
 PRIMARY KEY ( `comuImgNo` )
) COMMENT = '우리가그린(커뮤니티) 이미지';



CREATE TABLE `US_GREEN_COMMENT`
(
    `commentNo`    INTEGER NOT NULL AUTO_INCREMENT COMMENT '댓글번호',
    `commentDetail`    VARCHAR(150) NOT NULL COMMENT '댓글내용',
    `commentDate`    DATE DEFAULT '0000-00-00' NOT NULL COMMENT '작성일',
    `commentDelete`    CHAR(1) DEFAULT 'N' NOT NULL COMMENT '삭제여부',
    `comuNo`    INTEGER NOT NULL COMMENT '커뮤니티번호',
    `userNo`    INTEGER NOT NULL COMMENT '회원번호',
 PRIMARY KEY ( `commentNo` )
) COMMENT = '우리가그린(댓글)';



CREATE TABLE `US_GREEN_COMMENT_GOOD`
(
    `cLikeNo`    INTEGER NOT NULL AUTO_INCREMENT COMMENT '번호',
    `cLikeCount`    INTEGER COMMENT '좋아요',
    `commentNo`    INTEGER NOT NULL COMMENT '댓글번호',
    `userNo`    INTEGER NOT NULL COMMENT '회원번호',
 PRIMARY KEY ( `cLikeNo` )
) COMMENT = '우리가그린(댓글) 좋아요';

