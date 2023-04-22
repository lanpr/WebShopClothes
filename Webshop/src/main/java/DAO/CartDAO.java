package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import Utils.CookieUtils;
import model.CartSanPham;
import model.Sanpham;
import model.Size;

public class CartDAO {

	static List<CartSanPham> listCart = new ArrayList<>();

	public static List<CartSanPham> getListCart() {
		return listCart;
	}

//	public static CartSanPham getCartSPById(String id) {
//		for(CartSanPham cart : listCart) {
//			if(cart.getMaSP().equals(id)) {
//				return cart;
//			}
//		}
//		return null;
//	}
	public static Double getThanhTien() {
		Double thanhTien = 0.0;
		for (CartSanPham sp : listCart) {
			thanhTien += sp.getTongtien();
		}
		return thanhTien;
	}

	public static void printList() {
		for (CartSanPham sp : listCart) {
			System.out.println(sp.getTenSP() + "---------" + sp.getMaSP() + " ----" + sp.getSl());
		}
	}

	public static void addCartSP(CartSanPham cart) {
		boolean ck = true;
		for (CartSanPham c : listCart) {
			if (c.getMaSP().equals(cart.getMaSP())) {
				if (c.getSize().equals(cart.getSize())) {
					c.setSl(c.getSl() + 1);
					ck = false;
					break;
				}
			}
		}
		if (ck) {
			listCart.add(cart);
		}

	}

	public static void setListCart(String txtCart) {
		listCart.clear();
		if (txtCart != null) {
			String cart[] = txtCart.split("/");
			for (String c : cart) {
				String size = c.substring(c.lastIndexOf(":") + 1);
				String maSP = c.substring(0, c.lastIndexOf(":"));
				Sanpham sp = SanPhamDAO.findSanPhamByID(maSP);
				CartSanPham cartSP = new CartSanPham(sp.getMasp(), sp.getTensp(), sp.getHinh().get(0).getTenhinh(), 1,size);
				addCartSP(cartSP);

			}
		}
	}

	public static void giamCartSP(String maSP, String size, String sl) {
		printList();
		try {
			if (sl.equals("-1")) {
				for (CartSanPham cart : listCart) {
					if (cart.getMaSP().equals(maSP) && cart.getSize().equals(size)) {
						if (cart.getSl() > 1) {
							cart.setSl(cart.getSl() - 1);
						} else {
							listCart.remove(cart);
							break;
						}
					}
				}
			} else if (sl.equals("1")) {
				for (CartSanPham cart : listCart) {
					if (cart.getMaSP().equals(maSP) && cart.getSize().equals(size)) {
						cart.setSl(cart.getSl() + 1);
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		printList();

	}

	public static String getStringtxtCart() {
		String txtCart = "";
		for (CartSanPham cart : listCart) {
			if(cart.getSl()>1) {
				for(int i=0;i<cart.getSl();i++) {
					if (txtCart.isEmpty()) {
						txtCart = cart.getMaSP() + ":" + cart.getSize();
					} else {
						txtCart += "/" + cart.getMaSP() + ":" + cart.getSize();
					}
				}
			}else {
				if (txtCart.isEmpty()) {
					txtCart = cart.getMaSP() + ":" + cart.getSize();
				} else {
					txtCart += "/" + cart.getMaSP() + ":" + cart.getSize();
				}
			}
			
		}

		return txtCart;
	}
	
	
	public static void removeCart(String maSP,String size) {
		for (CartSanPham cart : listCart) {
			if(cart.getMaSP().equals(maSP)&&cart.getSize().equals(size)) {
				listCart.remove(cart);
				break;
			}
		}
	}

}
