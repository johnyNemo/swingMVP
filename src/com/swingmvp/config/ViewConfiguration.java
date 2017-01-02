
package com.swingmvp.config;

/**
 *
 * @author marek
 */
public class ViewConfiguration {
    
    private String _name;
    
    private String _presenter;
    
    public ViewConfiguration(String name, String presenter)
    {
        _name = name;
        _presenter = presenter;
    }
    
    public String getName()
    {
        return _name;
    }
    
    public String getPresenter()
    {
        return _presenter;
    }
}
