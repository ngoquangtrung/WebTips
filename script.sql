USE [master]
GO
/****** Object:  Database [WebSiteGame]    Script Date: 17-Nov-21 22:59:08 ******/
CREATE DATABASE [WebSiteGame]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'WebSiteGame', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQL_TRUNG\MSSQL\DATA\WebSiteGame.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'WebSiteGame_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQL_TRUNG\MSSQL\DATA\WebSiteGame_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [WebSiteGame] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [WebSiteGame].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [WebSiteGame] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [WebSiteGame] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [WebSiteGame] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [WebSiteGame] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [WebSiteGame] SET ARITHABORT OFF 
GO
ALTER DATABASE [WebSiteGame] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [WebSiteGame] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [WebSiteGame] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [WebSiteGame] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [WebSiteGame] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [WebSiteGame] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [WebSiteGame] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [WebSiteGame] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [WebSiteGame] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [WebSiteGame] SET  DISABLE_BROKER 
GO
ALTER DATABASE [WebSiteGame] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [WebSiteGame] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [WebSiteGame] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [WebSiteGame] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [WebSiteGame] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [WebSiteGame] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [WebSiteGame] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [WebSiteGame] SET RECOVERY FULL 
GO
ALTER DATABASE [WebSiteGame] SET  MULTI_USER 
GO
ALTER DATABASE [WebSiteGame] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [WebSiteGame] SET DB_CHAINING OFF 
GO
ALTER DATABASE [WebSiteGame] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [WebSiteGame] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [WebSiteGame] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [WebSiteGame] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'WebSiteGame', N'ON'
GO
ALTER DATABASE [WebSiteGame] SET QUERY_STORE = OFF
GO
USE [WebSiteGame]
GO
/****** Object:  Table [dbo].[category]    Script Date: 17-Nov-21 22:59:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[category](
	[id_category] [int] IDENTITY(1,1) NOT NULL,
	[name_category] [nvarchar](50) NULL,
	[status] [int] NULL,
 CONSTRAINT [PK_category] PRIMARY KEY CLUSTERED 
(
	[id_category] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[comment]    Script Date: 17-Nov-21 22:59:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[comment](
	[id_user] [int] NOT NULL,
	[id_post] [int] NOT NULL,
	[time_cmt] [datetime] NULL,
	[content_cmt] [nvarchar](500) NULL,
	[status_cmt] [int] NULL,
	[id_cmtrep] [int] NULL,
 CONSTRAINT [PK_comment] PRIMARY KEY CLUSTERED 
(
	[id_user] ASC,
	[id_post] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[commentinfo]    Script Date: 17-Nov-21 22:59:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[commentinfo](
	[id_cmt] [int] IDENTITY(1,1) NOT NULL,
	[id_user] [int] NOT NULL,
	[id_post] [int] NOT NULL,
	[content_cmt] [nvarchar](500) NOT NULL,
	[time_create] [datetime] NULL,
	[status_cmt] [int] NULL,
	[id_cmtrep] [int] NULL,
 CONSTRAINT [PK_commentinfo] PRIMARY KEY CLUSTERED 
(
	[id_cmt] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[config]    Script Date: 17-Nov-21 22:59:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[config](
	[id_cofig] [int] IDENTITY(1,1) NOT NULL,
	[title] [nvarchar](50) NULL,
	[keyword] [nvarchar](300) NULL,
	[description] [nvarchar](300) NULL,
	[time_format] [nchar](30) NULL,
 CONSTRAINT [PK_config] PRIMARY KEY CLUSTERED 
(
	[id_cofig] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[likecmt]    Script Date: 17-Nov-21 22:59:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[likecmt](
	[id_user] [int] NOT NULL,
	[id_comment] [int] NOT NULL,
	[time_create] [datetime] NOT NULL,
 CONSTRAINT [PK_likecmt_1] PRIMARY KEY CLUSTERED 
(
	[id_user] ASC,
	[id_comment] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[log]    Script Date: 17-Nov-21 22:59:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[log](
	[id_log] [int] IDENTITY(1,1) NOT NULL,
	[id_user] [int] NOT NULL,
	[time_log] [datetime] NOT NULL,
	[logmessage] [nvarchar](max) NULL,
 CONSTRAINT [PK_log] PRIMARY KEY CLUSTERED 
(
	[id_log] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[post]    Script Date: 17-Nov-21 22:59:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[post](
	[id_post] [int] IDENTITY(1,1) NOT NULL,
	[src_img] [nvarchar](200) NULL,
	[summary] [nvarchar](300) NULL,
	[content_post] [nvarchar](max) NULL,
	[status_post] [int] NULL,
	[id_user] [int] NOT NULL,
	[id_category] [int] NOT NULL,
	[time_post] [datetime] NULL,
	[title] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_post] PRIMARY KEY CLUSTERED 
(
	[id_post] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[post_detail]    Script Date: 17-Nov-21 22:59:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[post_detail](
	[id_post] [int] NULL,
	[id_part] [int] IDENTITY(1,1) NOT NULL,
	[src_image] [nvarchar](200) NULL,
	[title_part] [nvarchar](300) NULL,
	[content_part] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[id_part] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[user]    Script Date: 17-Nov-21 22:59:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user](
	[id_user] [int] IDENTITY(1,1) NOT NULL,
	[name_user] [nvarchar](50) NOT NULL,
	[email] [nvarchar](50) NOT NULL,
	[pass] [nvarchar](50) NOT NULL,
	[gender] [int] NULL,
	[birthday] [date] NULL,
	[time_up] [datetime] NULL,
	[permission] [int] NOT NULL,
	[status_user] [int] NULL,
	[imageSrc] [nvarchar](300) NULL,
 CONSTRAINT [PK_user] PRIMARY KEY CLUSTERED 
(
	[id_user] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[commentinfo]  WITH CHECK ADD  CONSTRAINT [FK_commentinfo_post] FOREIGN KEY([id_post])
REFERENCES [dbo].[post] ([id_post])
GO
ALTER TABLE [dbo].[commentinfo] CHECK CONSTRAINT [FK_commentinfo_post]
GO
ALTER TABLE [dbo].[commentinfo]  WITH CHECK ADD  CONSTRAINT [FK_commentinfo_user] FOREIGN KEY([id_user])
REFERENCES [dbo].[user] ([id_user])
GO
ALTER TABLE [dbo].[commentinfo] CHECK CONSTRAINT [FK_commentinfo_user]
GO
ALTER TABLE [dbo].[likecmt]  WITH CHECK ADD  CONSTRAINT [FK_likecmt_commentinfo] FOREIGN KEY([id_comment])
REFERENCES [dbo].[commentinfo] ([id_cmt])
GO
ALTER TABLE [dbo].[likecmt] CHECK CONSTRAINT [FK_likecmt_commentinfo]
GO
ALTER TABLE [dbo].[likecmt]  WITH CHECK ADD  CONSTRAINT [FK_likecmt_user] FOREIGN KEY([id_user])
REFERENCES [dbo].[user] ([id_user])
GO
ALTER TABLE [dbo].[likecmt] CHECK CONSTRAINT [FK_likecmt_user]
GO
ALTER TABLE [dbo].[log]  WITH CHECK ADD  CONSTRAINT [FK_log_user] FOREIGN KEY([id_user])
REFERENCES [dbo].[user] ([id_user])
GO
ALTER TABLE [dbo].[log] CHECK CONSTRAINT [FK_log_user]
GO
ALTER TABLE [dbo].[post]  WITH CHECK ADD  CONSTRAINT [FK_post_category] FOREIGN KEY([id_category])
REFERENCES [dbo].[category] ([id_category])
GO
ALTER TABLE [dbo].[post] CHECK CONSTRAINT [FK_post_category]
GO
ALTER TABLE [dbo].[post_detail]  WITH CHECK ADD  CONSTRAINT [FK_post_detail_post] FOREIGN KEY([id_post])
REFERENCES [dbo].[post] ([id_post])
GO
ALTER TABLE [dbo].[post_detail] CHECK CONSTRAINT [FK_post_detail_post]
GO
/****** Object:  StoredProcedure [dbo].[sp_deleteuser]    Script Date: 17-Nov-21 22:59:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sp_deleteuser](
@iduser int)
as
update [dbo].[user] 
set status_user=0
where [dbo].[user].id_user=@iduser
GO
/****** Object:  StoredProcedure [dbo].[sproc_activeUser]    Script Date: 17-Nov-21 22:59:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sproc_activeUser](
@iduser int,
@status int)
as
begin
update [dbo].[user] 
set status_user=@status
where [dbo].[user].id_user=@iduser
end
GO
/****** Object:  StoredProcedure [dbo].[sproc_addcmt]    Script Date: 17-Nov-21 22:59:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sproc_addcmt](
@id_user int,
@id_post int,
@content nvarchar(500),
@time datetime,
@idrep int)
as
begin
insert into commentinfo(id_user,id_post,content_cmt,time_create,status_cmt,id_cmtrep)
values(@id_user,@id_post,@content,@time,1,@idrep)
end
GO
/****** Object:  StoredProcedure [dbo].[sproc_addpost]    Script Date: 17-Nov-21 22:59:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sproc_addpost](
@title nvarchar(50),
@src_img nvarchar(200),
@summary nvarchar(200),
@content nvarchar(max),
@status int,
@iduser int,
@idcategory int,
@time datetime)
as
begin
insert into post(title,src_img,summary,content_post,status_post,id_user,id_category,time_post)
values(@title,@src_img,@summary,@content,@status,@iduser,@idcategory,@time)
end
GO
/****** Object:  StoredProcedure [dbo].[sproc_adduser]    Script Date: 17-Nov-21 22:59:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sproc_adduser](
@name nvarchar(50),
@email nvarchar(50),
@pass nvarchar(50),
@gender int,
@birthday date,
@time datetime,
@permission int
)as
insert into [dbo].[user](name_user,email,pass,gender,birthday,time_up,permission,status_user) 
values(@name,@email,@pass,@gender,@birthday,@time,@permission,1)
GO
/****** Object:  StoredProcedure [dbo].[sproc_commmentofuser]    Script Date: 17-Nov-21 22:59:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sproc_commmentofuser]( 
@iduser int)
AS
BEGIN
	
	select commentinfo.id_cmt,commentinfo.id_post,commentinfo.status_cmt,commentinfo.time_create,commentinfo.content_cmt,post.title 
	from commentinfo inner join post 
	on commentinfo.id_post=post.id_post 
	where commentinfo.id_user=@iduser and commentinfo.status_cmt=1
	order by time_create desc
END
GO
/****** Object:  StoredProcedure [dbo].[sproc_deletecmt]    Script Date: 17-Nov-21 22:59:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sproc_deletecmt](
@idcmt int
)
as
begin
update commentinfo
set status_cmt=0 where id_cmt=@idcmt
end
GO
/****** Object:  StoredProcedure [dbo].[sproc_deletepost]    Script Date: 17-Nov-21 22:59:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sproc_deletepost](
@idpost int
) 
	
AS
BEGIN
 update post 
 set status_post=0
 where id_post=@idpost
END
GO
/****** Object:  StoredProcedure [dbo].[sproc_likecmt]    Script Date: 17-Nov-21 22:59:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sproc_likecmt](
@iduser int,
@idcmt int,
@time varchar(30))
AS
BEGIN
	insert into likecmt values(@iduser,@idcmt,@time)
END
GO
/****** Object:  StoredProcedure [dbo].[sproc_searchpost]    Script Date: 17-Nov-21 22:59:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sproc_searchpost](
@text nvarchar(300))
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	select * from post where title like '%'+@text+'%' except select* from post where status_post=0 order by time_post desc 
END
GO
/****** Object:  StoredProcedure [dbo].[sproc_selectComment]    Script Date: 17-Nov-21 22:59:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sproc_selectComment](
@idpost int
)
as
begin
select  commentinfo.id_user,commentinfo.id_post,commentinfo.content_cmt,commentinfo.time_create,commentinfo.status_cmt,[dbo].[user].name_user,commentinfo.id_cmtrep,commentinfo.id_cmt
from [dbo].[user] inner join commentinfo 
on [dbo].[user].id_user=commentinfo.id_user inner join post 
on post.id_post=commentinfo.id_post 
where post.id_post=@idpost and commentinfo.status_cmt=1 and commentinfo.id_cmtrep is null
order by time_create desc
end
GO
/****** Object:  StoredProcedure [dbo].[sproc_selectRepcmt]    Script Date: 17-Nov-21 22:59:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sproc_selectRepcmt](
@idpost int)
as
begin
select  commentinfo.id_user,commentinfo.id_post,commentinfo.content_cmt,commentinfo.time_create,commentinfo.status_cmt,[dbo].[user].name_user,commentinfo.id_cmtrep,commentinfo.id_cmt
from [dbo].[user] inner join commentinfo 
on [dbo].[user].id_user=commentinfo.id_user inner join post 
on post.id_post=commentinfo.id_post 
where post.id_post=@idpost and commentinfo.status_cmt=1
except
select  commentinfo.id_user,commentinfo.id_post,commentinfo.content_cmt,commentinfo.time_create,commentinfo.status_cmt,[dbo].[user].name_user,commentinfo.id_cmtrep,commentinfo.id_cmt
from [dbo].[user] inner join commentinfo 
on [dbo].[user].id_user=commentinfo.id_user inner join post 
on post.id_post=commentinfo.id_post 
where commentinfo.id_cmtrep is null
order by time_create asc
end
GO
/****** Object:  StoredProcedure [dbo].[sproc_unlike]    Script Date: 17-Nov-21 22:59:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[sproc_unlike](
@iduser int,
@idcmt int)
AS
BEGIN
delete likecmt where id_user=@iduser and id_comment=@idcmt
END
GO
/****** Object:  StoredProcedure [dbo].[sproc_updatepass]    Script Date: 17-Nov-21 22:59:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sproc_updatepass] (

@pass nvarchar(50),
@id int)
as 
begin
update [dbo].[user] 
set pass=@pass where id_user=@id
end
GO
/****** Object:  StoredProcedure [dbo].[sproc_updatePost]    Script Date: 17-Nov-21 22:59:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sproc_updatePost](
@id_post int,
@src_img nvarchar(200),
@summary nvarchar(300),
@status_post int,
@id_category int,
@title nvarchar(200)
)
as 
begin
update post
set src_img=@src_img,
	summary=@summary,
	status_post=@status_post,
	title=@title,
	id_category=@id_category
where id_post=@id_post
end
GO
/****** Object:  StoredProcedure [dbo].[sproc_updatePostDetail]    Script Date: 17-Nov-21 22:59:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[sproc_updatePostDetail](
@idpart int,
@src nvarchar(200),
@title nvarchar(300),
@content nvarchar(max)
)
as
begin 
update post_detail
set src_image=@src,
	title_part=@title,
	content_part=@content
where id_part=@idpart
end
GO
/****** Object:  StoredProcedure [dbo].[sproc_updateUser]    Script Date: 17-Nov-21 22:59:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[sproc_updateUser](
@id int,
@name nvarchar(50),
@email nvarchar(50),
@pass nvarchar(50),
@gender int,
@birthday date,
@permission int,
@statususer int
)
as
begin
update [dbo].[user]
set name_user=@name,
	email=@email,
	pass=@pass,
	birthday=@birthday,
	gender=@gender,
	permission=@permission,
	status_user=@statususer
where id_user=@id
end
GO
USE [master]
GO
ALTER DATABASE [WebSiteGame] SET  READ_WRITE 
GO
