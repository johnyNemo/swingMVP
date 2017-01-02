
package com.swingmvp;

import java.util.Observer;

/**
 *
 * @author marek
 */
public class StandardWindowDispatcher implements WindowDispatcher {
    
    private View _view;   
    
    public StandardWindowDispatcher(View view)
    {
        _view = view;
    }
    
    @Override
    public void dispatch(ServiceContainerInterface serviceContainer) {
        _view.observePresenterModel();
        _view.show();        
    }
    
    public View getDispatchedView()
    {
        return _view;
    }
}
