<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Add Two Number</title>
  <style>
    h1 {
      color: aqua;
      align-items: center;
    }
    .number {
      align-items: center;
    }
  </style>
</head>
<body>
<h1>ADD TWO NUMBER</h1>
<div class="number">
  <form action="addition_table" method="post">
    <table>
      <tr>
        <td>Enter 1st Number: </td>
        <td><input type="text" name="number1"></td>
      </tr>
      <tr>
        <td>Enter 2nd Number: </td>
        <td><input type="text" name="number2"></td>
      </tr>
      <tr>
        <td><input type="submit" value="Sum the Number"></td>
      </tr>
    </table>
  </form>
</div>
<a href="addition_table">Addition Table</a>
</body>
</html>