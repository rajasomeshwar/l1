<%@ include file="common/header.jspf" %>
<%@ include file="common/navigationBar.jspf" %>
   <div class="container">
   <h1>Enter the todo</h1>
   <form:form method="post"  modelAttribute="todo">
   <fieldset class="mb-3">
   <form:label path="Description"> Description :</form:label>
   <form:input type="text" path="description" required="required"/>
   <form:errors path="description" cssClass="text-warning"/>
   </fieldset>
    <form:input type="hidden" path="id" />
    <fieldset class="mb-3">
        <form:label path="targetdate">Target Date</form:label>
         <%
    // Get the current date in the format YYYY-MM-DD
    java.time.LocalDate today = java.time.LocalDate.now();
%>
<form:input type="date" value="${todo.targetdate}" path="targetdate" required="required" min="<%= today.toString() %>" />
    </fieldset>
     <form:input type="hidden" path="username" />
    <form:input type="hidden" path="done" /> 
    <input class="btn btn-success" type="submit"/>
   </form:form>
   </div>
   
<%@ include file="common/footer.jspf" %>