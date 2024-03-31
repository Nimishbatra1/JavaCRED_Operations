<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>
    <%@ taglib prefix = "x" 
   uri = "http://java.sun.com/jsp/jstl/xml" %>
   <%@ taglib prefix = "fn" 
   uri = "http://java.sun.com/jsp/jstl/functions" %>
    <title>Records Table</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    

<script>
document.addEventListener('DOMContentLoaded', function () {
    const filterEmail = document.getElementById('filterEmail');
    const filterPassword = document.getElementById('filterPassword');
    const filterUsername = document.getElementById('filterUsername');
    
    const rows = document.querySelectorAll('#recordsTable tbody tr');
    
    function applyFilter() {
        const emailText = filterEmail.value.toLowerCase();
        const passwordText = filterPassword.value.toLowerCase();
        const usernameText = filterUsername.value.toLowerCase();
        
        rows.forEach(row => {
            const emailCell = row.querySelector('td:nth-child(1)');
            const passwordCell = row.querySelector('td:nth-child(2)');
            const usernameCell = row.querySelector('td:nth-child(3)');
            
            const email = emailCell.textContent.toLowerCase();
            const password = passwordCell.textContent.toLowerCase();
            const username = usernameCell.textContent.toLowerCase();
            
            const emailMatch = email.includes(emailText);
            const passwordMatch = password.includes(passwordText);
            const usernameMatch = username.includes(usernameText);
            
            if (emailMatch && passwordMatch && usernameMatch) {
                row.style.display = '';
            } else {
                row.style.display = 'none';
            }
        });
    }
    
    filterEmail.addEventListener('input', applyFilter);
    filterPassword.addEventListener('input', applyFilter);
    filterUsername.addEventListener('input', applyFilter);
    
    // Initial filtering
    applyFilter();
});
</script>

    
    <style>
    
   
    
        body {
            font-family: Arial, sans-serif;
            background-color: Black;
            margin: 0;
            padding: 0;
            justify-content: center;
            align-items: center;
        }
        h1 {
            text-align: center;
            margin-bottom: 20px;
        }
        #recordsTable {
            width: 100%;
            max-width: 900px;
            border-collapse: collapse;
            margin: 20px auto;
            background-color: DeepSkyBlue;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
            border-bottom: 4px solid White;
        }
        #recordsTable th, #recordsTable td {
            padding: 12px;
            text-align: left;
        }
        #recordsTable th {
            background-color:Blue;
            height:10px;
            border-bottom: 8px solid White;
        }
        #recordsTable tr:nth-child(even) {
            background-color:cyan;
            border-bottom: 4px solid White;
        }
        #add-btn {
        background-color:Green;
         align:center;
         
        color: White;
        padding: 10px 20px;
        font-size: 16px;
        border: 2px solid Black;
        cursor: pointer;
        border-radius: 5px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    }

    #add-btn:hover {
        background-color:White;
        color: Blue;
    }
     #update-btn {
        background-color:#E2F516;
         align:center;
        color: Black;
        padding: 10px 20px;
        font-size: 16px;
        border: 2px solid White;
        cursor: pointer;
        border-radius: 5px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    }

    #update-btn:hover {
        background-color:White;
        color: Blue;
    }
     #delete-btn {
        background-color: red;
         align:center;
        color: Black;
        padding: 10px 20px;
        font-size: 16px;
        border: 2px solid White;
        cursor: pointer;
        border-radius: 5px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    }

    #delete-btn:hover {
        background-color:White;
        color: Blue;
    }
    
    .action-btn {
    display: inline-block;
    padding: 10px 20px;
    font-size: 16px;
    color: white;
    text-align: center;
    text-decoration: none;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    transition: background-color 0.3s, color 0.3s;
}

.action-btn:hover {
    color: blue;
}
     #pdf-btn {
        background-color: #16E2F5;
         align:center;
        color: Black;
        padding: 10px 20px;
        font-size: 16px;
        border: 2px solid White;
        cursor: pointer;
        border-radius: 5px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    }

    #pdf-btn:hover {
        background-color:White;
        color: Blue;
    }
     .button-container {
            display: flex;
            justify-content:center;
            margin-top: 20px;
            
            align-items: center;
        }

    </style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

    <h1>Records Table</h1>
    <div class="button-container">
        <a id="pdf-btn" href="/pdf">Export To Pdf <i class="fa fa-file-pdf-o" aria-hidden="true"></i></a>
        <a id="update-btn" href="/excel" style=background-color:#FF69B4>Export To Excel <i class="fa fa-file-excel-o" aria-hidden="true"></i></a>
    </div>
    
 
<table id="recordsTable">
    <thead id="recordsTable th">
        <tr>
            <th>Email</th>
            <th>Password</th>
            <th>Username</th>
            <th>Action</th>
            <th>Action</th>
        </tr>
        <tr>
            <td><input type="text" id="filterEmail" placeholder="Filter by Email"></td>
            <td><input type="text" id="filterPassword" placeholder="Filter by Password"></td>
            <td><input type="text" id="filterUsername" placeholder="Filter by Username"></td>
            <td></td>
            <td></td>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${showRecord}" var="list">
            <tr>
                <td>${list.email}</td>
                <td>${list.password}</td>
                <td>${list.username}</td>
                <td><a id="update-btn" href="/update?id=${list.id}" class="action-btn">UPDATE <i class="fa fa-pencil-square-o" aria-hidden="true"></i></a></td>
                <td><a id="delete-btn" href="/delete?id=${list.id}" class="action-btn">DELETE <i class="fa fa-trash-o" aria-hidden="true"></i></a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>

    
     <div style="text-align: center; margin-top: 20px;">
        <a id="add-btn" href="/add">ADD ITEM <i class="fa fa-plus-square" aria-hidden="true"></i></a>
    </div>
</body>
</html>
