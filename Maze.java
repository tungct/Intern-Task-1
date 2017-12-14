
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class Maze {
	public static void main(String[] args) {
		//
		JFrame frame = new JFrame();
		frame.setSize(650, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MazePanel mp = new MazePanel();
		frame.add(mp);
		frame.setVisible(true);
	}

	public static class MazePanel extends JPanel {
		private static final long serialVersionUID = -566807999447681130L;
		private int[][] maze = { // khởi tạo ma trận mảng 2 chiều
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1 },
				{ 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1 },
				{ 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1 },
				{ 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 2, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1 },
				{ 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
		private int sizeh, sizew, start, end;

		public MazePanel() {
			// Kích thước ma trận
			sizeh = 21;
			sizew = 31;
			start = 10;
			end = 0;
			solve();
			repaint(); // vẽ ma trận và lời giải
		}



		/**
		 * Implement một phương pháp tìm đường nào đó.
		 * <p>
		 * Yêu cầu : Vẽ đường đi từ điểm bắt đầu đến điểm kết thúc. Không hiện
		 * các phần thừa - là các phần đường cụt hoặc đường đi bị sai. Chỉ vẽ
		 * tuyến đường chính đi từ điểm đầu (màu vàng) đến màu đỏ.
		 * <p>
		 * Đường đi từ điểm đầu đến điểm cuối được tô màu xanh dương, để tô màu
		 * xanh dương hãy set giá trị của điểm trên ma trận sang một số > 2
		 */

		public static ArrayList<Point2D> neighbor(Point2D a, int[][] maze, ArrayList<Point2D> arr){
			ArrayList<Point2D> neis = new ArrayList<>();
			if(a.getX() ==0 && a.getY() != 0) {
				if (maze[a.getY()][a.getX() + 1] == 0 || maze[a.getY()][a.getX() + 1] == 2) {
					neis.add(arr.get(a.getY()*31 + a.getX() + 1));
				}
				if (maze[a.getY() + 1][a.getX()] == 0 || maze[a.getY() + 1][a.getX()] == 2) {
					neis.add(arr.get((a.getY()+1)*31 + a.getX()));
				}
				if (maze[a.getY() - 1][a.getX()] == 0 || maze[a.getY() - 1][a.getX()] == 2) {
					neis.add(arr.get((a.getY()-1)*31 + a.getX()));
				}
			}
			if(a.getX() !=0 && a.getY() != 0 && a.getX() != 30 && a.getY() != 20) {
				if (maze[a.getY()][a.getX() + 1] == 0 || maze[a.getY()][a.getX() + 1] == 2) {
					neis.add(arr.get(a.getY()*31 + a.getX() + 1));
				}
				if (maze[a.getY()][a.getX() - 1] == 0 || maze[a.getY()][a.getX() - 1] == 2) {
					neis.add(arr.get(a.getY()*31 + a.getX() - 1));
				}
				if (maze[a.getY() + 1][a.getX()] == 0 || maze[a.getY() + 1][a.getX()] == 2) {
					neis.add(arr.get((a.getY()+1)*31 + a.getX()));
				}
				if (maze[a.getY() - 1][a.getX()] == 0 || maze[a.getY() - 1][a.getX()] == 2) {
					neis.add(arr.get((a.getY()-1)*31 + a.getX()));
				}
			}
			return neis;
		}

		public static int[][] Dijkstra(int[][] maze, Point2D start, Point2D end, ArrayList<Point2D> arr){
			Map k = new HashMap();
			Map d = new HashMap();
			Map p = new HashMap();
			for (int j = 0;j<arr.size();j++){
				Point2D pt = arr.get(j);
				k.put(pt, false);
				d.put(pt, 100);
				p.put(pt,null);
			}
			d.put(start,0);
//        k.put(start,true);
			int count = 0;
			while((boolean)k.get(end) == false){
				int minValue = 100;
				Point2D pointMin = new Point2D();
				for(int j = 0;j<arr.size();j++){
					//get Min
					if((boolean)k.get(arr.get(j))==false){
						if(minValue > (int)d.get(arr.get(j))){
							minValue = (int)d.get(arr.get(j));
							pointMin = arr.get(j);
						}
					}

				}
				k.put(pointMin,true);
				ArrayList neig = neighbor(pointMin,maze,arr);
				for (int i=0;i<neig.size();i++){
					if((boolean)k.get(neig.get(i)) == false){
						if((int)d.get(neig.get(i)) > (int)d.get(pointMin) + 1){
							d.put(neig.get(i), (int)d.get(pointMin) + 1);
							p.put(neig.get(i),pointMin);
						}
					}
				}
			}
			Point2D temp = end;
			while (temp != start){
				temp = (Point2D) p.get(temp);
				int y = temp.getY();
				int x = temp.getX();
				maze[y][x] = 3;
			}
			int y = start.getY();
			int x = start.getX();
			maze[y][x] = 3;
			return maze;
		}

		public void solve() {
			// Hàm này chứa phương pháp tìm đường từ điểm start đến vị
			// trí màu đỏ trên ma trận
			ArrayList<Point2D> arr = new ArrayList<>();
			for (int i =0;i<21;i++){
				for (int j=0;j<31;j++){
					Point2D point = new Point2D(j,i);
					arr.add(point);
				}
			}
			Point2D start = arr.get(10*31+0);
			Point2D end = arr.get(10*31+15);
			maze = Dijkstra(maze,start,end,arr);
		}

		public void paintComponent(Graphics g) // vẽ ma trận + lời giải
		{
			super.paintComponent(g);
			for (int j = 0; j < sizew; j++)
				for (int i = 0; i < sizeh; i++) {
					if (i == start && j == end)
						g.setColor(Color.yellow);
					else if (maze[i][j] == 0)
						g.setColor(Color.white);
					else if (maze[i][j] == 1)
						g.setColor(Color.black);
					else if (maze[i][j] == 2)
						g.setColor(Color.red);
					else
						g.setColor(Color.blue); // blue là màu của lời giải
					g.fillRect(j * 20, i * 20, 20, 20);
				}
		}
	}
}
