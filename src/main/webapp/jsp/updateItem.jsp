 <!DOCTYPE html>
<head >
 <style>
        body {
            display: flex;
            margin: 0;
            padding: 0;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            font-family: 'Jost', sans-serif;
            background: linear-gradient(to bottom, #0f0c29, #302b63, #24243e);
        }
        
        form {
            background-color: white;
            padding: 70px 120px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            display: flex;
            flex-direction: column;
            align-items: center;
            border: 5px solid Black;
        }
        
        h1 {
             text-align: center;
    margin-bottom:50px;
    color: White;
    height: 100px;
    display: flex;
    justify-content: center;
    align-items: center;
    border: 5px solid #00BFFF;	
}

        
        label {
            display: block;
            margin: 10px 0;
        }
        
        input {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            width: 100%;
            max-width: 300px;
        }
        
        #update-btn {
            background-color:cyan;
            color: Black;
            padding: 10px 20px;
            font-size: 16px;
            border: 2px solid Black;
            cursor: pointer;
            border-radius: 5px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            margin-top: 20px;
        }
        
        #update-btn:hover {
            background-color: White;
            color: Blue;
        }
    </style>
    </head>
        
<body >
<form action="Update" type="post">
<h1 style=background-color:Black >Updating an Item</h1>

<label for="username">Change User Name:</label>
<input type="text" name="username" placeholder="User name" value="${username}" required="">

<label for="email">Change Email :</label>
<input type="email" name="email" placeholder="Email"value="${email}" required="">

<label for="password">Reset Password :</label>
<input type="password" name="pass" placeholder="Password" value="${password}" required="">

<input type="hidden" name="id" placeholder="ID" value="${id}" required="">


 <Button type="submit" id="update-btn">UPDATE</Button>

</form>

</body>
</html>
