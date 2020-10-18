package com.lme.robot.mars;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MarsGrid {
    private Grid maxGrid;
    private Set<Grid> scentedGrids = new HashSet<>();

    public MarsGrid(int x, int y) {
        this.maxGrid = new Grid(x, y);
    }

    public int getMaxX() {
        return maxGrid.getX();
    }

    public int getMaxY() {
        return maxGrid.getY();
    }

    public void addScentedGrid(int x, int y, MarsOrientation direction) {
        scentedGrids.add(new Grid(x, y, direction));
    }

    public boolean isScented(int x, int y, MarsOrientation direction) {
        return scentedGrids.contains(new Grid(x, y, direction));
    }

    class Grid {
        private int x;
        private int y;
        private MarsOrientation direction;

        public Grid(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Grid(int x, int y, MarsOrientation direction) {
            this(x, y);
            this.direction = direction;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public MarsOrientation getDirection() {
            return direction;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Grid grid = (Grid) o;
            return x == grid.x &&
                    y == grid.y &&
                    direction == grid.direction;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, direction);
        }
    }

}
