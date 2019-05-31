<div class="container-product">
    <a class="container-product-link" href="${pageContext.request.contextPath}/product/?id=${product.getID()}&full=true">
        <img class="image-background-product"
             src="${pageContext.request.contextPath}/assets/images/${product.getUrlImage()}"
             alt="${product.getName()}">
        <div class="container-title-product">
            <div class="title-product">
                <p class="title-text-product">${product.getName()}</p>
            </div>
        </div>
    </a>
    <div class="price-product">
        <form action="${pageContext.request.contextPath}/caddy/add" method="post">
            <input type="hidden" name="id" value="${product.getID()}">
            <button class="price-button-product" type="submit">
                <p class="price-text-product">
                    CHF ${String.format("%.2f",product.getPrice())}-
                </p>
                <img class="price-image-caddy-product" src="${pageContext.request.contextPath}/assets/images/caddie.png"
                     alt="Checkout">
            </button>
        </form>
    </div>
</div>
