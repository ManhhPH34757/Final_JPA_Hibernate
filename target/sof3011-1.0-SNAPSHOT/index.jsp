<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Shoe Auth - Your Style</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</head>
<body>
    <jsp:include page="components/header.jsp"></jsp:include>
    <div class="container">
        <c:if test="${page == null}">
            <div class="row">
                <div class="col-6 m-0 p-0">
                    <img src="https://th.bing.com/th/id/OIG1..S7AKX9IlU5VCKcuDIxO?pid=ImgGn" alt="" width="100%">
                </div>
                <div class="col-6 m-0 p-0">
                    <img src="https://th.bing.com/th/id/OIG1.pGq7qAhoeSVRfgnseJfF?pid=ImgGn" alt="" width="100%">
                </div>
            </div>
        </c:if>

        <c:if test="${page != null}">
            <jsp:include page="${page}"></jsp:include>
        </c:if>
    </div>

</body>
</html>