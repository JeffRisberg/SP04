<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url var="saveUrl" value="/user/save"/>
<form:form method="post" action="${saveUrl}">
  <form:hidden path="id" />
  <form:hidden path="password" />
  <form:hidden path="loginCount" /> 
  <form:hidden path="lastLoggedIn" />  
  <form:hidden path="city" />
  <form:hidden path="state" /> 
  <form:hidden path="country" />   
    
  <table>
  <tr>
    <td>Username:</td>
    <td><form:input path="username"/></td>
  </tr> 
  <tr>
    <td>First Name:</td>
    <td><form:input path="firstName"/></td>
  </tr> 
  <tr>
    <td>Last Name:</td>
    <td><form:input path="lastName"/></td>
  </tr>
  <tr>
   <td>Email:</td>
   <td>
    <span class="input"><form:input path="email" cssErrorClass="error"
        class="required oneInput" /> <form:errors path="email" cssClass="error" />
    </span>
   </td>
  </tr>
  <tr>
   <td>Date Format:</td>
   <td>
    <form:select path="dateFormat">
      <option value="">(Use Org Setting)</option>
      <form:options items="${dateFormatList}" itemValue="id" itemLabel="formatString" />
    </form:select>
   </td>
  </tr>
  <tr>
   <td>Negative Number Format:</td>
   <td>
    <form:select path="negativeNumberFormat">
      <option value="">(Use Org Setting)</option>
      <form:options items="${negativeNumberFormatList}" itemValue="id" itemLabel="name" />
    </form:select>
   </td>
  </tr>   
  <tr>
   <td>Role(s):</td>
   <td>
    <span class="input">
      <form:select path="roles" multiple="true"
        cssErrorClass="error" class="required oneInput multiple">
        <form:options items="${rolesList}" itemValue="id" itemLabel="name" />
      </form:select> 
      <form:errors path="roles" cssClass="error" />
    </span>
   </td>
  </tr>
  </table>
  
  <div class="botButtons">
  <input class="save" type="submit" value="Submit"/>
  </div>
</form:form>
