#include <cmath>
#include "Point.h"

Point::Point(const int x, const int y) {
	x_ = x;
	y_ = y;
}

double Point::Distance(const Point &p) const {
	double distance = (x_ - p.get_x()) * (x_ - p.get_x());
	distance += (y_ - p.y_) * (y_ - p.y_);
	return sqrt(distance);
}

void Point::SetLocation(const int x, const int y) {
	x_ = x;
	y_ = y;
}
 
