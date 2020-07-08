package com.vereshchagin.nikolay.pepegafood.home.paging.catalog

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.vereshchagin.nikolay.pepegafood.R
import com.vereshchagin.nikolay.pepegafood.home.repository.model.CatalogItem

/**
 * Адаптер для списка каталога на главной странице.
 */
class CatalogAdapter : PagedListAdapter<CatalogItem, CatalogItemHolder>(
    CATALOG_COMPARATOR
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogItemHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_catalog, parent, false)
        return CatalogItemHolder(
            view
        )
    }

    override fun onBindViewHolder(holder: CatalogItemHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {

        /**
         * Компаратор для сравнения авто-корзин.
         */
        val CATALOG_COMPARATOR = object : DiffUtil.ItemCallback<CatalogItem>() {

            override fun areItemsTheSame(oldItem: CatalogItem, newItem: CatalogItem) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: CatalogItem, newItem: CatalogItem) =
                oldItem.title == newItem.title
        }
    }
}