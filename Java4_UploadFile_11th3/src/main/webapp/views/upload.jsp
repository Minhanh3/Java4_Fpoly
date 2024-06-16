<%--
  Created by IntelliJ IDEA.
  User: Manhdepzai
  Date: 3/11/2024
  Time: 10:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">

<head>
  <title>Title</title>
  <!-- Required meta tags -->
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

  <!-- Bootstrap CSS v5.2.1 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous" />
</head>

<body>
<div class="container mt-5">
  <div class="row">
    <h2>Upload Photo</h2>
    <form action="#" method="post" enctype="multipart/form-data">
      <div class="mb-3 col-7">
        <label for="" class="form-label">Id</label>
        <input type="text" name="id" id="" class="form-control" placeholder="" aria-describedby="helpId" />
      </div>
      <div class="mb-3 col-7">
        <label for="" class="form-label">Full Name</label>
        <input type="text" name="name" id="" class="form-control" placeholder="" aria-describedby="helpId" />
      </div>
      <div class="mb-3 col-7">
        <label for="" class="form-label">Choose file</label>
        <input type="file" class="form-control" name="photo" id="" placeholder="" aria-describedby="fileHelpId" />
      </div>
      <div>
        <button type="submit" class="btn btn-primary">Save</button>
        <button type="reset" class=" btn btn-primary">Cancel</button>
      </div>
    </form>
  </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
        integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
        crossorigin="anonymous"></script>
</body>

</html>