package cs3450.resources;

import java.util.Vector;

public class Receipt {
	int ReceiptID;
	int CustomerID;
	Vector<Item> productsSold;
	Vector<Double> prices;
}
