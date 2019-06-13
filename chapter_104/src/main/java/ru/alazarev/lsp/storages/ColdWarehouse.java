package ru.alazarev.lsp.storages;

public class ColdWarehouse extends StorageDecorator {
    public ColdWarehouse(Storage storageDecorator) {
        super(storageDecorator);
    }
}
