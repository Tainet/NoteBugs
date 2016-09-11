package by.epamlab.dao;

import java.util.List;
import java.util.ListIterator;

import by.epamlab.beans.User;

public interface IteratorDAO extends ListIterator<List<User>> {
	void setSort(String sort);
	String getSort();
	String getDirection();
}
