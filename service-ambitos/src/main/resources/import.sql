USE [db_service_ambitos]

SET IDENTITY_INSERT [dbo].[ambito] ON 
INSERT [dbo].[ambito] ([ambito_id], [nombre]) VALUES (1, 'LIMA')
INSERT [dbo].[ambito] ([ambito_id], [nombre]) VALUES (2, 'PROVINCIA')
SET IDENTITY_INSERT [dbo].[ambito] OFF

SET IDENTITY_INSERT [dbo].[sub_ambito] ON 
INSERT [dbo].[sub_ambito] ([sub_ambito_id], [nombre], [activo], [ambito_id]) VALUES (1, 'LIMA', 1, 1)
INSERT [dbo].[sub_ambito] ([sub_ambito_id], [nombre], [activo], [ambito_id]) VALUES (2, 'PROVINCIA URBANA', 1, 2)
INSERT [dbo].[sub_ambito] ([sub_ambito_id], [nombre], [activo], [ambito_id]) VALUES (3, 'PROVINCIA RURAL', 1, 2 )
INSERT [dbo].[sub_ambito] ([sub_ambito_id], [nombre], [activo], [ambito_id]) VALUES (4, 'PROVINCIA LEJANA', 1, 2 )
SET IDENTITY_INSERT [dbo].[sub_ambito] OFF
