import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.border.EmptyBorder;

public class ScrapbookSwingApp {

    private static final int WINDOW_WIDTH = 900;
    private static final int WINDOW_HEIGHT = 750;
    private static final int IMAGE_WIDTH = 400;
    private static final int IMAGE_HEIGHT = 300;
    private static final int PADDING = 10;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Scrapbook de Lugares Icônicos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new GridLayout(2, 2, PADDING, PADDING));
        mainPanel.setBorder(new EmptyBorder(PADDING, PADDING, PADDING, PADDING));

        mainPanel.add(createImagePanel(
            "https://upload.wikimedia.org/wikipedia/commons/8/85/Tour_Eiffel_Wikimedia_Commons_%28cropped%29.jpg",
            "Torre Eiffel, Paris"
        ));

        mainPanel.add(createImagePanel(
            "https://upload.wikimedia.org/wikipedia/commons/4/4f/Christ_the_Redeemer_-_Cristo_Redentor.jpg",
            "Cristo Redentor, Rio de Janeiro"
        ));

        mainPanel.add(createImagePanel(
            "https://upload.wikimedia.org/wikipedia/commons/d/dd/Lady_Liberty_under_a_blue_sky_%28cropped%29.jpg",
            "Estátua da Liberdade, Nova York"
        ));

        mainPanel.add(createImagePanel(
            "https://upload.wikimedia.org/wikipedia/commons/d/de/Colosseo_2020.jpg",
            "Coliseu, Roma"
        ));
        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                frame.revalidate();
                frame.repaint();
            }
        });
    }
    private static JPanel createImagePanel(String imageUrl, String caption) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.setBackground(Color.WHITE);

        JLabel imageLabel = new JLabel("Carregando imagem...");
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setPreferredSize(new Dimension(IMAGE_WIDTH, IMAGE_HEIGHT));
        imageLabel.setMinimumSize(new Dimension(IMAGE_WIDTH, IMAGE_HEIGHT));
        imageLabel.setMaximumSize(new Dimension(IMAGE_WIDTH, IMAGE_HEIGHT));
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel captionLabel = new JLabel(caption);
        captionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        captionLabel.setFont(new Font("Arial", Font.BOLD, 14));

        panel.add(Box.createVerticalStrut(PADDING));
        panel.add(imageLabel);
        panel.add(Box.createVerticalStrut(PADDING));
        panel.add(captionLabel);
        panel.add(Box.createVerticalStrut(PADDING));
        loadImageAsync(imageUrl, imageLabel);

        return panel;
    }
    private static void loadImageAsync(String imageUrl, JLabel imageLabel) {
        SwingWorker<ImageIcon, Void> worker = new SwingWorker<>() {
            @Override
            protected ImageIcon doInBackground() {
                try {
                    URL url = new URL(imageUrl);
                    BufferedImage originalImage = ImageIO.read(url);

                    if (originalImage != null) {
                        Image scaledImage = getScaledImage(originalImage, IMAGE_WIDTH, IMAGE_HEIGHT);
                        return new ImageIcon(scaledImage);
                    }
                } catch (IOException e) {
                    System.out.println("Erro ao carregar imagem: " + e.getMessage());
                }
                return createPlaceholderIcon(imageUrl);
            }

            @Override
            protected void done() {
                try {
                    ImageIcon icon = get();
                    imageLabel.setIcon(icon);
                    imageLabel.setText("");
                } catch (Exception e) {
                    imageLabel.setText("Erro ao carregar imagem");
                    e.printStackTrace();
                }
            }
        };

        worker.execute();
    }
    private static Image getScaledImage(Image srcImg, int targetWidth, int targetHeight) {
        BufferedImage originalImage = convertToBufferedImage(srcImg);
        int originalWidth = originalImage.getWidth();
        int originalHeight = originalImage.getHeight();

        double scaleFactor = Math.min(
            (double) targetWidth / originalWidth,
            (double) targetHeight / originalHeight
        );

        int scaledWidth = (int) (originalWidth * scaleFactor);
        int scaledHeight = (int) (originalHeight * scaleFactor);

        BufferedImage resizedImage = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = resizedImage.createGraphics();

        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();

        return resizedImage;
    }
    private static BufferedImage convertToBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }
        int width = img.getWidth(null);
        int height = img.getHeight(null);
        BufferedImage bimage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        return bimage;
    }
    private static ImageIcon createPlaceholderIcon(String failedUrl) {
        BufferedImage placeholderImage = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = placeholderImage.createGraphics();

        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillRect(0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);

        g2d.setColor(Color.RED);
        g2d.setFont(new Font("Arial", Font.BOLD, 14));
        g2d.drawString("Erro ao carregar imagem", 20, IMAGE_HEIGHT / 2 - 20);
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.PLAIN, 12));
        String displayUrl = failedUrl;
        if (displayUrl.length() > 40) {
            displayUrl = displayUrl.substring(0, 37) + "...";
        }
        g2d.drawString(displayUrl, 20, IMAGE_HEIGHT / 2 + 10);

        g2d.dispose();

        return new ImageIcon(placeholderImage);
    }
}