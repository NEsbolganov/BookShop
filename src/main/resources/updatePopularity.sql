UPDATE books
SET popularity = bought + 0.7 * cart + 0.4 * postponed;
