<%@ include file="common/header.jspf" %>
<%@ include file="common/navigationBar.jspf" %>
<div class="container">
<div class="mb-0">
<h2>hi ${name}</h2>
<h3>Your Todos </h3>
</div>
<hr>
<table class="table" >
    <thead>
    <tr>
         <th>Description</th>
         <th>Target Date</th>
         <th>IsDone?</th>
         <th>Update</th>
         <th>Delete</th>
    </tr>
     </thead>
     <tbody>
      <c:forEach var="todo" items="${todos}" >
       <tr>
           <td>${todo.description }</td>
           <td>${todo.targetdate }</td>
           <td>${todo.done }</td>
          <td> <a href="update?id=${todo.id}" class="btn btn-warning">Update </a></td>
          <td> <a href="delete?id=${todo.id }" class="btn btn-success">Delete</a></td>
       </tr>
       </c:forEach>
     </tbody>
</table>

<a href="add" class="btn btn-success">Add</a>
  <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
  <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
  </div>
  <script type="text/javascript">
  $('#targetDate').datepicker({
	  format:'yyyy-mm-dd'
  });
  </script>
<%@ include file="common/footer.jspf" %>