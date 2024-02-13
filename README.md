# OrangeHRM_Katalon

## Cara cloning project ke Katalon Studio

- Buka aplikasi katalon studio
- klik logo git di pojok kiri atas
![git image](https://github.com/niamxmain/OrangeHRM_Katalon/blob/main/images/git.png)
- Setelah itu akan muncul form dan isi sesuai dengan credentials.
![git clone](https://github.com/niamxmain/OrangeHRM_Katalon/blob/main/images/clone.png)
*note (password didapat dari setting github / personal token)*

## Test Case
Pada penerapan pengujian kali ini saya menggunakan Tools [Katalon Studio](https://katalon.com/).
Pengujian saya lakukan pada website [OrangHRM](https://opensource-demo.orangehrmlive.com/web/index.php/auth/login).

Adapun beberapa fitur yang saya uji dalam portfolio saya ini:

## Fitur Positive

1. **Login**
	- Login with valid admin
	- Logout
	
2. **Admin**
	- Access admin menu
	- Add new user
	- Search user with specific data
	- Edit user without update password
	- Edit user with update password
	
3. **PIM**
	- Access PIM menu
	- Add new employee
	- Search employee
	- Update employee
	- Delete employee
	
## Fitur Negative

1. **Login**
	- Login invalid credentials
	- Login without password
	- Login without username
