package com.example.MyBookShopApp.data;

public enum BookFileType {
    PDF(".pdf"), EPUB(".epub"), FB2(".fb2");

    private final String bookFileTypeExtension;


    BookFileType(String bookFileTypeExtension) {
        this.bookFileTypeExtension = bookFileTypeExtension;
    }

    public static String getFileExtensionType(String typeId){
        switch (typeId){
            case "1": return BookFileType.PDF.bookFileTypeExtension;
            case "2": return BookFileType.EPUB.bookFileTypeExtension;
            case "3": return BookFileType.FB2.bookFileTypeExtension;
            default: return "";
        }
    }
}
