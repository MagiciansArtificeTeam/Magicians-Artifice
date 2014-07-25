package magiciansartifice.client.guis.book;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public abstract class GuiTab extends GuiRectangle 
{
    int values, del;
    private String name;

    public GuiTab(String name, int id) 
    {
        super(-62, 10 + 19*id, 19, 18);        
        this.name = name;
        values = 0;
        del = 0;
    }
    
    public String getName() 
    {
        return name;
    }
    
    public abstract void drawBackground(GuiMagicBook gui, int x, int y, int page);
    public abstract void drawForeground(GuiMagicBook gui, int x, int y, int page);
    public void mouseClick(GuiMagicBook gui, int x, int y, int button) {}
    public void mouseMoveClick(GuiMagicBook gui, int x, int y, int button, long timeSinceClicked) {}
    public void mouseReleased(GuiMagicBook gui, int x, int y, int button) {}

    public int getMaxPages()
    {
        return 1;
    }
    
}
