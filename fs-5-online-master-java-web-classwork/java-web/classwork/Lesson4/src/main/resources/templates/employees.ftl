<html>
<body>
<p>
    Employees:
    <#if employees??>
        <#list employees as employee>
            <p> Employee name: ${employee.firstName} | Department name: ${employee.department.departmentName}
        </#list>
    </#if>

</p>
</body>
</html>