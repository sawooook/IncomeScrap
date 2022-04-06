package com.o3.apiserver.domain.scrap.type;

public enum ScrapType {
    SCRAP_PAY, // 급여
    SCRAP_TAX; // 산출세액

    ScrapType convertScrapType(String type) {
        switch (type) {
            case "급여":
                return SCRAP_PAY;

            case "산출세액":
                return SCRAP_TAX;
        }

        return null;
    }
}
