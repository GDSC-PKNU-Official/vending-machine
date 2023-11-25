package service;

import util.message.SystemMessage;

public class AdminServiceImpl implements AdminService {
    private ProductService productService;
    private SystemMessage systemMessage;

    public AdminServiceImpl(ProductService productService, SystemMessage systemMessage) {
        this.productService = productService;
        this.systemMessage = systemMessage;
    }
}
