package ch.hesge.onlineshop.filters;

import ch.hesge.onlineshop.models.Product;
import ch.hesge.onlineshop.services.DataValidator;
import ch.hesge.onlineshop.services.ProductsServices;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@WebFilter("/caddy/add")
public class CaddyAddFilter implements Filter {

    private final ProductsServices productsServices;
    private final DataValidator dataValidator;

    @Inject
    public CaddyAddFilter(ProductsServices productsServices, DataValidator dataValidator) {
        this.dataValidator = dataValidator;
        this.productsServices = productsServices;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // rien à faire
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        if (dataValidator.isInt(req.getParameter("id"))) {
            Product product = productsServices.getProduct(Integer.parseInt(req.getParameter("id")));
            Map<Product, Integer> caddy = (Map<Product, Integer>) req.getSession().getAttribute("caddy");
            if (caddy.containsKey(product)) {
                caddy.put(product, caddy.get(product) + 1);
            } else {
                caddy.put(product, 1);
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        // rien à faire
    }
}
