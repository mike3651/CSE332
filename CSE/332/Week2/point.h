#ifndef _POINT_H_
#define _POINT_H_

class Point {
public:
	Point(const int x, const int y);
	int get_x() const { return x_; }
	int get_y() const { return y_;}
	double Distance(const Point &p) const;
	void SetLocation(const int x, const int y);

private:
	int x_;
	int y_;
};

#endif